package com.example.cse225_notes.unit_5

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cse225_notes.R
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ExternalStorageDemo : AppCompatActivity() {

    lateinit var uName: EditText
    lateinit var pin: EditText
    lateinit var export: Button

    lateinit var fstream: FileOutputStream
    private val fileName = "SampleFile.txt"
    private val filePath = "MyFileStorage"
    lateinit var myExternalFile: File

    var mPermission = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage_demo)

        uName = findViewById(R.id.uname)
        pin = findViewById(R.id.pin)
        export = findViewById(R.id.export)

        export.setOnClickListener {
            val userName = """
                ${uName.text}
            """.trimIndent()
            val password = pin.text.toString()

            try {
                if (ContextCompat.checkSelfPermission(this, mPermission[0]) !=
                    PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, mPermission[1]) !=
                    PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(this, mPermission, 23)
                } else {

                    Toast.makeText(applicationContext, "File Permission Granted", Toast.LENGTH_LONG)
                        .show()

                    if (userName.isEmpty() || password.isEmpty())
                        Toast.makeText(
                            this, "Either of field is empty",
                            Toast.LENGTH_SHORT
                        ).show()
                    else {
                        myExternalFile = File(getExternalFilesDir(filePath), fileName)
                        fstream = FileOutputStream(myExternalFile)
                        fstream.write(userName.toByteArray())
                        fstream.write(password.toByteArray())
                        fstream.close()
                        Toast.makeText(
                            applicationContext, "Details saved in " +
                                    myExternalFile!!.absolutePath, Toast.LENGTH_LONG
                        ).show()
                    }
                }

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

    }
}