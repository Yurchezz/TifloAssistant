package ua.iot.lviv.shazam

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ua.iot.lviv.client.api.MoviecontrollerApi
import ua.iot.lviv.client.model.SoundBoard
import ua.iot.lviv.shazam.service.DatabaseService
import ua.iot.lviv.shazam.service.InternetChecker
import java.io.File
import java.net.InetAddress
import java.util.*

class ListViewAdapter//constructor
    (//variables
    internal var mContext: Context,
    internal var modellist: MutableList<SoundBoard>,
    internal var internetConnectionStatus: Boolean
) : BaseAdapter() {
    val client = MoviecontrollerApi()
    internal var inflater: LayoutInflater
    internal var arrayList: ArrayList<SoundBoard>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arrayList = ArrayList()
        this.arrayList.addAll(modellist)
    }

    inner class ViewHolder {
        internal var mTitleTv: TextView? = null
        internal var mDescTv: TextView? = null
        internal var mIconIv: ImageView? = null
    }

    override fun getCount(): Int {
        return modellist.size
    }

    override fun getItem(i: Int): Any {
        return modellist[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(postition: Int, view: View?, parent: ViewGroup): View {
        var photoBytes: ByteArray? = null
        var view = view
        val holder: ViewHolder
        val databaseService = DatabaseService(mContext)
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.row, null)

            //locate the views in row.xml
            holder.mTitleTv = view!!.findViewById(R.id.mainTitle)
            holder.mDescTv = view.findViewById(R.id.mainDesc)
            holder.mIconIv = view.findViewById(R.id.mainIcon)


            view.tag = holder
            view.downloadStatus.visibility = View.GONE

        } else {
            holder = view.tag as ViewHolder
        }

        val maxLength =
            if (modellist[postition].description.length < 30) modellist[postition].description.length else 30;

        //set the results into textviews
        holder.mTitleTv!!.text = modellist[postition].movieName
        holder.mDescTv!!.text = modellist[postition].description.substring(0, maxLength) + "..."
        //set the result in imageview
        GlobalScope.launch(Dispatchers.IO) {

            val databaseMovieList = databaseService.getAllMovies()
            withContext(Dispatchers.Main) {
                databaseMovieList.forEach { movieItem ->
                    if (movieItem.title.equals(modellist[postition].movieName)) {
                        if (movieItem.downloadStatus) {
                            view.downloadStatus.visibility = View.VISIBLE

                        } else {
                            view.downloadStatus.visibility = View.GONE
                        }

                    }
                }

            }
            photoBytes = if (internetConnectionStatus) {
                client.getForegroundPhotoByIdUsingGET(modellist[postition].id)
            } else {
                File(
                    mContext.cacheDir,
                    "${modellist[postition].movieName}.jpg"
                ).readBytes()
            }
            val image = BitmapFactory.decodeByteArray(photoBytes, 0, photoBytes!!.size)
            withContext(Dispatchers.Main) {
                holder.mIconIv!!.setImageBitmap(image)

            }
        }


        view.setOnClickListener {
            var immediateConnectionStatus = false
            GlobalScope.launch (Dispatchers.IO) {
                immediateConnectionStatus = InternetChecker.isInternetAvaliable()
              val immediateResultOfDownloadMovie = databaseService.getMovieByTitle(modellist[postition].movieName)

                withContext(Dispatchers.Main) {
                    val intent = Intent(mContext, DetailPageActivity::class.java)
                    intent.putExtra("actionBarTitle", modellist[postition].movieName)
                    intent.putExtra("contentTv", modellist[postition].description)
                    intent.putExtra("id", modellist[postition].id)

                    if (immediateResultOfDownloadMovie != null) {
                        intent.putExtra("internetConnectionStatus", false)
                        mContext.startActivity(intent)
                    } else if (internetConnectionStatus) {
                        if (!immediateConnectionStatus) {
                            Toast.makeText(
                                mContext,
                                "Cannot connect to the server, please try again",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            intent.putExtra("internetConnectionStatus", internetConnectionStatus)
                            mContext.startActivity(intent)
                        }

                    }
                }

            }
        }



        return view
    }

    //filter
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        modellist.clear()
        if (charText.length == 0) {
            modellist.addAll(arrayList)
        } else {
            for (model in arrayList) {
                if (model.movieName.toLowerCase(Locale.getDefault())
                        .contains(charText)
                ) {
                    modellist.add(model)
                }
            }
        }
        notifyDataSetChanged()
    }


}