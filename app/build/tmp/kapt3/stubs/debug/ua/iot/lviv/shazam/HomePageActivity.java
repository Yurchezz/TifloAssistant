package ua.iot.lviv.shazam;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020(X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u00101\u00a8\u0006<"}, d2 = {"Lua/iot/lviv/shazam/HomePageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lua/iot/lviv/shazam/ListViewAdapter;", "getAdapter$app_debug", "()Lua/iot/lviv/shazam/ListViewAdapter;", "setAdapter$app_debug", "(Lua/iot/lviv/shazam/ListViewAdapter;)V", "arrayList", "Ljava/util/ArrayList;", "Lua/iot/lviv/client/model/SoundBoard;", "getArrayList", "()Ljava/util/ArrayList;", "setArrayList", "(Ljava/util/ArrayList;)V", "arrayOfDescriptions", "", "", "getArrayOfDescriptions", "()Ljava/util/List;", "arrayOfTitles", "getArrayOfTitles", "client", "Lua/iot/lviv/client/api/MoviecontrollerApi;", "getClient", "()Lua/iot/lviv/client/api/MoviecontrollerApi;", "icon", "", "getIcon", "()[I", "setIcon", "([I)V", "internetConnectionStatus", "", "getInternetConnectionStatus", "()Z", "setInternetConnectionStatus", "(Z)V", "listView", "Landroid/widget/ListView;", "getListView$app_debug", "()Landroid/widget/ListView;", "setListView$app_debug", "(Landroid/widget/ListView;)V", "movieList", "", "getMovieList", "setMovieList", "(Ljava/util/List;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class HomePageActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final ua.iot.lviv.client.api.MoviecontrollerApi client = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<? extends ua.iot.lviv.client.model.SoundBoard> movieList;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ListView listView;
    @org.jetbrains.annotations.NotNull()
    public ua.iot.lviv.shazam.ListViewAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    public int[] icon;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<ua.iot.lviv.client.model.SoundBoard> arrayList;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> arrayOfTitles = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> arrayOfDescriptions = null;
    private boolean internetConnectionStatus;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final ua.iot.lviv.client.api.MoviecontrollerApi getClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ua.iot.lviv.client.model.SoundBoard> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends ua.iot.lviv.client.model.SoundBoard> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ListView getListView$app_debug() {
        return null;
    }
    
    public final void setListView$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.ListView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ua.iot.lviv.shazam.ListViewAdapter getAdapter$app_debug() {
        return null;
    }
    
    public final void setAdapter$app_debug(@org.jetbrains.annotations.NotNull()
    ua.iot.lviv.shazam.ListViewAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getIcon() {
        return null;
    }
    
    public final void setIcon(@org.jetbrains.annotations.NotNull()
    int[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<ua.iot.lviv.client.model.SoundBoard> getArrayList() {
        return null;
    }
    
    public final void setArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<ua.iot.lviv.client.model.SoundBoard> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getArrayOfTitles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getArrayOfDescriptions() {
        return null;
    }
    
    public final boolean getInternetConnectionStatus() {
        return false;
    }
    
    public final void setInternetConnectionStatus(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public HomePageActivity() {
        super();
    }
}