package ua.iot.lviv.shazam;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00017B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u0010.\u001a\u00020+H\u0016J\"\u00101\u001a\u0002022\u0006\u00103\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u0001022\u0006\u00105\u001a\u000206H\u0016R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00068"}, d2 = {"Lua/iot/lviv/shazam/ListViewAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "modellist", "", "Lua/iot/lviv/client/model/SoundBoard;", "internetConnectionStatus", "", "(Landroid/content/Context;Ljava/util/List;Z)V", "arrayList", "Ljava/util/ArrayList;", "getArrayList$app_debug", "()Ljava/util/ArrayList;", "setArrayList$app_debug", "(Ljava/util/ArrayList;)V", "client", "Lua/iot/lviv/client/api/MoviecontrollerApi;", "getClient", "()Lua/iot/lviv/client/api/MoviecontrollerApi;", "inflater", "Landroid/view/LayoutInflater;", "getInflater$app_debug", "()Landroid/view/LayoutInflater;", "setInflater$app_debug", "(Landroid/view/LayoutInflater;)V", "getInternetConnectionStatus$app_debug", "()Z", "setInternetConnectionStatus$app_debug", "(Z)V", "getMContext$app_debug", "()Landroid/content/Context;", "setMContext$app_debug", "(Landroid/content/Context;)V", "getModellist$app_debug", "()Ljava/util/List;", "setModellist$app_debug", "(Ljava/util/List;)V", "filter", "", "charText", "", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "postition", "view", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "app_debug"})
public final class ListViewAdapter extends android.widget.BaseAdapter {
    @org.jetbrains.annotations.NotNull()
    private final ua.iot.lviv.client.api.MoviecontrollerApi client = null;
    @org.jetbrains.annotations.NotNull()
    private android.view.LayoutInflater inflater;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<ua.iot.lviv.client.model.SoundBoard> arrayList;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<ua.iot.lviv.client.model.SoundBoard> modellist;
    private boolean internetConnectionStatus;
    
    @org.jetbrains.annotations.NotNull()
    public final ua.iot.lviv.client.api.MoviecontrollerApi getClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.LayoutInflater getInflater$app_debug() {
        return null;
    }
    
    public final void setInflater$app_debug(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<ua.iot.lviv.client.model.SoundBoard> getArrayList$app_debug() {
        return null;
    }
    
    public final void setArrayList$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<ua.iot.lviv.client.model.SoundBoard> p0) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object getItem(int i) {
        return null;
    }
    
    @java.lang.Override()
    public long getItemId(int i) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int postition, @org.jetbrains.annotations.Nullable()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    public final void filter(@org.jetbrains.annotations.NotNull()
    java.lang.String charText) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext$app_debug() {
        return null;
    }
    
    public final void setMContext$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ua.iot.lviv.client.model.SoundBoard> getModellist$app_debug() {
        return null;
    }
    
    public final void setModellist$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<ua.iot.lviv.client.model.SoundBoard> p0) {
    }
    
    public final boolean getInternetConnectionStatus$app_debug() {
        return false;
    }
    
    public final void setInternetConnectionStatus$app_debug(boolean p0) {
    }
    
    public ListViewAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.List<ua.iot.lviv.client.model.SoundBoard> modellist, boolean internetConnectionStatus) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lua/iot/lviv/shazam/ListViewAdapter$ViewHolder;", "", "(Lua/iot/lviv/shazam/ListViewAdapter;)V", "mDescTv", "Landroid/widget/TextView;", "getMDescTv$app_debug", "()Landroid/widget/TextView;", "setMDescTv$app_debug", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "getMIconIv$app_debug", "()Landroid/widget/ImageView;", "setMIconIv$app_debug", "(Landroid/widget/ImageView;)V", "mTitleTv", "getMTitleTv$app_debug", "setMTitleTv$app_debug", "app_debug"})
    public final class ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView mTitleTv;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView mDescTv;
        @org.jetbrains.annotations.Nullable()
        private android.widget.ImageView mIconIv;
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getMTitleTv$app_debug() {
            return null;
        }
        
        public final void setMTitleTv$app_debug(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getMDescTv$app_debug() {
            return null;
        }
        
        public final void setMDescTv$app_debug(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageView getMIconIv$app_debug() {
            return null;
        }
        
        public final void setMIconIv$app_debug(@org.jetbrains.annotations.Nullable()
        android.widget.ImageView p0) {
        }
        
        public ViewHolder() {
            super();
        }
    }
}