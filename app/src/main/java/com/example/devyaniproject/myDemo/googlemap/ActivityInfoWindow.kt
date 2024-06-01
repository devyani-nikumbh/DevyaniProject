package com.example.devyaniproject.myDemo.googlemap

import com.example.devyaniproject.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.databinding.ActivityMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class ActivityInfoWindow : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap) {
        map.mapType = GoogleMap.MAP_TYPE_NORMAL
        map.uiSettings.isZoomControlsEnabled = true
        val title = "This is Title"
        val subTitle = "This is \nSubtitle"

        //Marker
        val markerOpt = MarkerOptions()
        markerOpt.position(
            LatLng(
                java.lang.Double.valueOf(46.8182),
                java.lang.Double.valueOf(8.2275)
            )
        )
            .title(title)
            .snippet(subTitle)

        //Set Custom InfoWindow Adapter
        val adapter = CustomInfoWindowAdapter(this)
        map.setInfoWindowAdapter(adapter)
        map.addMarker(markerOpt)!!.showInfoWindow()
    }
}