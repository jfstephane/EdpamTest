package jfsl.edpam.Fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import jfsl.edpam.R;


public class PictureFragment extends Fragment {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private static int RESULT_LOAD_IMAGE = 6;
    Button button;
    ImageView imageView;
    Button buttonLoad;
    Button buttonLocation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.picture_fragment, container, false);


        button = (Button) view.findViewById(R.id.button);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,
                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

            }
        });*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                getActivity().startActivityFromFragment(PictureFragment.this, cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);


            }
        });


        buttonLoad = (Button) view.findViewById(R.id.select);
        buttonLoad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                getActivity().startActivityFromFragment(PictureFragment.this, i, RESULT_LOAD_IMAGE);


            }
        });


        buttonLocation = (Button) view.findViewById(R.id.button3);
        buttonLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create new fragment and transaction
                Fragment newFragment = new LocationFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.upnav, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();




            }
        });








        return view;


    }

    /*public void toLocation(View view) {
        Fragment mFragment = new LocationFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, mFragment).commit();
    }*/



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
         super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK && data != null) {

                    Bitmap bmp = (Bitmap) data.getExtras().get("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();

                    /*bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            // convert byte array to Bitmap

            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                    byteArray.length);*/

                    imageView.setImageBitmap(bmp);
                    // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                    Uri selectedImage = getImageUri(getActivity(), bmp);
                    String realPath=getRealPathFromURI(selectedImage);
                    selectedImage = Uri.parse(realPath);

                }
            }


        }catch(Exception e){
            Toast.makeText(this.getActivity(), e+"Something went wrong", Toast.LENGTH_LONG).show();

        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = getActivity().getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }



}






