package com.example.dailyhunt_clone


import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.sucho.placepicker.AddressData
import com.sucho.placepicker.Constants
import com.sucho.placepicker.Constants.GOOGLE_API_KEY
import com.sucho.placepicker.MapType
import com.sucho.placepicker.PlacePicker
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class CreatePostActivity : AppCompatActivity() {


    var mCurrentPhotoPath = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post2)
        val applicationInfo =
            packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)

        findViewById<ImageView>(R.id.btnLocation).setOnClickListener {

            val intent = PlacePicker.IntentBuilder()
                .setLatLong(40.748672, -73.985628)
                .showLatLong(true)
                .setMapZoom(12.0f)
                .setAddressRequired(true)
                .hideMarkerShadow(true)
                .setMarkerImageImageColor(R.color.colorPrimary)
                .setMapRawResourceStyle(R.raw.map_style)
                .setMapType(MapType.NORMAL)
                .setPlaceSearchBar(true, GOOGLE_API_KEY)
                .onlyCoordinates(true)
                .hideLocationButton(true)
                .disableMarkerAnimation(true)
                .build(this)
            startActivityForResult(intent, Constants.PLACE_PICKER_REQUEST)
        }
        initView()

    }

    private fun initView() {
        val back = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val camera = findViewById<ImageView>(R.id.camera)
        camera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (cameraIntent.resolveActivity(packageManager) != null) {
                // Create the File where the photo should go
                var photoFile: File? = null
                try {
                    photoFile = createImageFile()

                } catch (ex: IOException) {
                    // Error occurred while creating the File

                }

                // Continue only if the File was successfully created
                if (photoFile != null) {
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile))
                    startActivityForResult(cameraIntent, 11)
                }
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Constants.PLACE_PICKER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val addressData = data?.getParcelableExtra<AddressData>(Constants.ADDRESS_INTENT)
                findViewById<TextView>(R.id.tvLocation).text = addressData.toString()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    @Throws(IOException::class)
    fun createImageFile(): File {

        // Create an image file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        /* val storageDir = Environment.getExternalStoragePublicDirectory(
             Environment.DIRECTORY_PICTURES
         )*/
        val storageDir = this.getExternalFilesDir(
            Environment.DIRECTORY_PICTURES
        )
        val image = File.createTempFile(
            imageFileName, // prefix
            ".jpg", // suffix
            storageDir      // directory
        )

        mCurrentPhotoPath = "file:" + image.absolutePath
        return image
    }
}