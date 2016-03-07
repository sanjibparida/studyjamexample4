package somshubham.gdgmap4;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
String lonvalue,latvalue,textmsg;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20, 85);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in BBSR"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    public void post(View view){


        EditText lat=(EditText)findViewById(R.id.editText2);
        EditText log=(EditText)findViewById(R.id.editText);
        EditText area=(EditText)findViewById(R.id.editText3);

        latvalue=lat.getText().toString();

        int value1,value2;
       value1=Integer.parseInt(latvalue);
        lonvalue=log.getText().toString();
        value2=Integer.parseInt(lonvalue);
        textmsg=area.getText().toString();

        LatLng sydney = new LatLng(value1, value2);
        mMap.addMarker(new MarkerOptions().position(sydney).title(textmsg));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        Toast.makeText(MapsActivity.this, "you have done", Toast.LENGTH_SHORT).show();




    }
}
