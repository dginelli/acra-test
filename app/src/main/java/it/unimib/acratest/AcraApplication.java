package it.unimib.acratest;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.acra.ACRA;
import org.acra.BuildConfig;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.ToastConfigurationBuilder;
import org.acra.data.StringFormat;

public class AcraApplication extends Application {

    private static final String TAG = AcraApplication.class.getSimpleName();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        Log.d(TAG, "attachBaseContext() called, ACRA initialized");

        ACRA.init(this, new CoreConfigurationBuilder()
                // Core configuration:
                .withBuildConfigClass(BuildConfig.class)
                .withReportFormat(StringFormat.JSON)
                .withPluginConfigurations(
                        // Each plugin you chose above can be configured with its builder like this:
                        new ToastConfigurationBuilder()
                                .withText(getString(R.string.acra_toast_text))
                                .build()
                )
        );
    }
}
