package com.iusmaharjan.vocabuilder;

import android.app.Application;
import android.util.Log;

import java.util.Date;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;
import timber.log.Timber;

public class VocabuilderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
        configureRealm();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    private void configureRealm() {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this)
                .name("words.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .migration(new RealmMigration() {
                    @Override
                    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                        RealmSchema schema = realm.getSchema();
                        if (oldVersion == 0) {
                            schema.create("Word")
                                    .addField("word", String.class)
                                    .addField("note", String.class);
                            oldVersion++;
                        }
                    }
                }).build();
        Realm.setDefaultConfiguration(realmConfig);

    }


    //TODO: add analytics
    /** A tree which logs important information for crash reporting. */
    private static class CrashReportingTree extends Timber.Tree {
        @Override protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            //CrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    //CrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    //CrashLibrary.logWarning(t);
                }
            }
        }
    }
}
