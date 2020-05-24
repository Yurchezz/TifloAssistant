package ua.iot.lviv.shazam.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lua/iot/lviv/shazam/service/DatabaseService;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Lua/iot/lviv/shazam/database/DatabaseApp;", "deleteMovieByTitle", "", "title", "", "getAllMovies", "", "Lua/iot/lviv/shazam/database/model/Movie;", "getMovieByTitle", "insertMovie", "movie", "app_debug"})
public final class DatabaseService {
    private final ua.iot.lviv.shazam.database.DatabaseApp db = null;
    
    public final void deleteMovieByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ua.iot.lviv.shazam.database.model.Movie getMovieByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    public final void insertMovie(@org.jetbrains.annotations.NotNull()
    ua.iot.lviv.shazam.database.model.Movie movie) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ua.iot.lviv.shazam.database.model.Movie> getAllMovies() {
        return null;
    }
    
    public DatabaseService(@org.jetbrains.annotations.NotNull()
    android.content.Context appContext) {
        super();
    }
}