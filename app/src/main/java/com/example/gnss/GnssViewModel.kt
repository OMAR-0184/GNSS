package com.example.gnss

import android.annotation.SuppressLint
import android.content.Context
import android.location.GnssMeasurementsEvent
import android.location.LocationManager
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GnssViewModel : ViewModel() {
    private val _gnssData = MutableStateFlow("Waiting for GNSS data...")
    val gnssData = _gnssData.asStateFlow()

    private var locationManager: LocationManager? = null

    private val gnssCallback = object : GnssMeasurementsEvent.Callback() {
        override fun onGnssMeasurementsReceived(event: GnssMeasurementsEvent) {
            val sb = StringBuilder()
            sb.append("Satellites tracked: ${event.measurements.size}\n\n")

            event.measurements.forEach { measurement ->
                sb.append("SVID: ${measurement.svid} | CN0: ${measurement.cn0DbHz}\n")
            }

            _gnssData.value = sb.toString()
        }
    }

    @SuppressLint("MissingPermission")
    fun startListening(context: Context) {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager?.registerGnssMeasurementsCallback(gnssCallback)
    }

    fun stopListening() {
        locationManager?.unregisterGnssMeasurementsCallback(gnssCallback)
    }

    override fun onCleared() {
        stopListening()
        super.onCleared()
    }
}