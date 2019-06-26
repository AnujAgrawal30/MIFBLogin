package com.example.fblogin;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fblogin.Api;
import com.example.fblogin.R;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.fblogin.CustomAdapter;
import com.example.fblogin.R;
import com.example.fblogin.User.User;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
//
//    private final Context mContext = this;
    private final String LOG_TAG = "BNK";
//    private TextView mTextMessage;
//    BottomNavigationView navView = findViewById(R.id.nav_view);
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//
//        mTextMessage = findViewById(R.id.message);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//        selectImage(); // selects a photo from Gallery
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
//            Uri fileUri = data.getData();
//            if (fileUri != null) {
//                uploadFile(fileUri); // uploads the file to the web service
//            }
//        }
//    }
//
//    private void uploadFile(Uri fileUri) {
//
//        String filePath = getRealPathFromUri(fileUri);
//        if (filePath != null && !filePath.isEmpty()) {
//            File file = new File(filePath);
//            if (file.exists()) {
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(Api.BASE_URL)
//                        .build();
//
//                Api service = retrofit.create(Api.class);
//
//                // creates RequestBody instance from file
//                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//                // MultipartBody.Part is used to send also the actual filename
//                MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
//                // adds another part within the multipart request
//                String descriptionString = "Sample description";
//                RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
//                // executes the request
//                Call<ResponseBody> call = service.postFile(body, description);
//                call.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call,
//                                           Response<ResponseBody> response) {
//                        Log.i(LOG_TAG, "success");
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e(LOG_TAG, t.getMessage());
//                    }
//                });
//            }
//        }
//    }
//
//    private void selectImage() {
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("image/*");
//        startActivityForResult(intent, 100);
//    }
//
//    public String getRealPathFromUri(final Uri uri) {
//        // DocumentProvider
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(mContext, uri)) {
//            // ExternalStorageProvider
//            if (isExternalStorageDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                if ("primary".equalsIgnoreCase(type)) {
//                    return Environment.getExternalStorageDirectory() + "/" + split[1];
//                }
//            }
//            // DownloadsProvider
//            else if (isDownloadsDocument(uri)) {
//
//                final String id = DocumentsContract.getDocumentId(uri);
//                final Uri contentUri = ContentUris.withAppendedId(
//                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
//
//                return getDataColumn(mContext, contentUri, null, null);
//            }
//            // MediaProvider
//            else if (isMediaDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                Uri contentUri = null;
//                if ("image".equals(type)) {
//                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//                } else if ("video".equals(type)) {
//                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//                } else if ("audio".equals(type)) {
//                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                }
//
//                final String selection = "_id=?";
//                final String[] selectionArgs = new String[]{
//                        split[1]
//                };
//
//                return getDataColumn(mContext, contentUri, selection, selectionArgs);
//            }
//        }
//        // MediaStore (and general)
//        else if ("content".equalsIgnoreCase(uri.getScheme())) {
//
//            // Return the remote address
//            if (isGooglePhotosUri(uri))
//                return uri.getLastPathSegment();
//
//            return getDataColumn(mContext, uri, null, null);
//        }
//        // File
//        else if ("file".equalsIgnoreCase(uri.getScheme())) {
//            return uri.getPath();
//        }
//
//        return null;
//    }
//
//    private String getDataColumn(Context context, Uri uri, String selection,
//                                 String[] selectionArgs) {
//
//        Cursor cursor = null;
//        final String column = "_data";
//        final String[] projection = {
//                column
//        };
//
//        try {
//            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
//                    null);
//            if (cursor != null && cursor.moveToFirst()) {
//                final int index = cursor.getColumnIndexOrThrow(column);
//                return cursor.getString(index);
//            }
//        } finally {
//            if (cursor != null)
//                cursor.close();
//        }
//        return null;
//    }
//
//    private boolean isExternalStorageDocument(Uri uri) {
//        return "com.android.externalstorage.documents".equals(uri.getAuthority());
//    }
//
//    private boolean isDownloadsDocument(Uri uri) {
//        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
//    }
//
//    private boolean isMediaDocument(Uri uri) {
//        return "com.android.providers.media.documents".equals(uri.getAuthority());
//    }
//
//    private boolean isGooglePhotosUri(Uri uri) {
//        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
//    }
//}

    ArrayList<User> Users, data;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        mTextMessage = findViewById(R.id.message);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listView=(ListView)findViewById(R.id.list);

        Users= new ArrayList<>();
        takedata();
        Toast.makeText(getApplicationContext(), Integer.toString(Users.size()), Toast.LENGTH_SHORT).show();

//        Users.add(new User(1, "Apple Pie", "@android:drawable/ic_dialog_info", "Android 1.0", "1","September 23, 2008", "sample blog", "Yes", "@android:drawable/ic_dialog_info", "sldkfj", "sdfkl"));
//        Users.add(new User(2, "Android 1.1", "2","February 9, 2009", "sdfkj", "KJfjsdlk", "kldfjskj", "slkdfj", "skdlfj"));
//        Users.add(new User(3, "Android 1.5", "3","April 27, 2009", "sdfkj", "KJfjsdlk", "kldfjskj", "slkdfj", "skdlfj"));
//        Users.add(new User("Donut","Android 1.6","4","September 15, 2009"));
//        Users.add(new User("Eclair", "Android 2.0", "5","October 26, 2009"));
//        Users.add(new User("Froyo", "Android 2.2", "8","May 20, 2010"));
//        Users.add(new User("Gingerbread", "Android 2.3", "9","December 6, 2010"));
//        Users.add(new User("Honeycomb","Android 3.0","11","February 22, 2011"));
//        Users.add(new User("Ice Cream Sandwich", "Android 4.0", "14","October 18, 2011"));
//        Users.add(new User("Jelly Bean", "Android 4.2", "16","July 9, 2012"));
//        Users.add(new User("Kitkat", "Android 4.4", "19","October 31, 2013"));
//        Users.add(new User("Lollipop","Android 5.0","21","November 12, 2014"));
//        Users.add(new User("Marshmallow", "Android 6.0", "23","October 5, 2015"));


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                User User= Users.get(position);
//
//                Snackbar.make(view, User.getName()+"\n"+User.getType()+" API: "+User.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//            }
//        });
    }

    private void takedata(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<User>> call = api.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                //In this point we got our hero list
                //thats damn easy right ;)
                List<User> heroList = response.body();
                Users.addAll(heroList);
                adapter= new CustomAdapter(Users,getApplicationContext());

                listView.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), Integer.toString(Users.size()), Toast.LENGTH_SHORT).show();

                //now we can do whatever we want with this list

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
