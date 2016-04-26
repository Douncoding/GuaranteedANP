package com.douncoding.guaranteedanp.net;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.douncoding.guaranteedanp.common.Constants;
import com.douncoding.guaranteedanp.common.DatabaseManager;
import com.example.dao.Place;
import com.example.dao.PlaceDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NETService extends IntentService {
    public static final String TAG = NETService.class.getSimpleName();

    private static final String ACTION_LOAD_PLACE = "com.douncoding.guaranteedanp.net.action.LOADPLACE";
    private static final String ACTION_BAZ = "com.douncoding.guaranteedanp.net.action.BAZ";

    private static final String EXTRA_PARAM1 = "com.douncoding.guaranteedanp.net.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.douncoding.guaranteedanp.net.extra.PARAM2";

    private OkHttpClient client = new OkHttpClient();
    private DatabaseManager mDBManager = new DatabaseManager(this);

    public NETService() {
        super("NETService");
    }

    public static void startActionLoadPlaces(Context context) {
        Intent intent = new Intent(context, NETService.class);
        intent.setAction(ACTION_LOAD_PLACE);
        context.startService(intent);
    }

    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, NETService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOAD_PLACE.equals(action)) {
                handleActionLoadPlace();
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    private void handleActionLoadPlace() {
        String url = Constants.Url.HOST + Constants.Url.PLACE;

        try {
            String body = run(url);

            Type type = new TypeToken<ArrayList<Place>>(){}.getType();
            ArrayList<Place> places = new Gson().fromJson(body, type);

            PlaceDao placeDao = mDBManager.openWritable().getPlaceDao();
            placeDao.insertInTx(places);

            mDBManager.printAllPlace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleActionBaz(String param1, String param2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }



    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
