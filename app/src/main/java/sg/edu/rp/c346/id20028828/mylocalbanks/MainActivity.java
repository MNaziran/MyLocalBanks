package sg.edu.rp.c346.id20028828.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnDBS, btnOCBC, btnUOB;
    String btnClicked = "";
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);
        tvTitle = findViewById(R.id.tvMyLocalBanks);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == btnDBS) {
            btnClicked = getString(R.string.dbs);
        } else if (v == btnOCBC) {
            btnClicked = getString(R.string.ocbc);
        } else if (v == btnUOB) {
            btnClicked = getString(R.string.uob);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.WebsiteSelection) {
            if (btnClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbs_web)));
                startActivity(intent);
            } else if (btnClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbc_web)));
                startActivity(intent);
            } else if (btnClicked.equalsIgnoreCase(getString(R.string.uob))) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uob_web)));
                startActivity(intent);
            }

            return true;
        } else if (id == R.id.ContactSelection) {
            if (btnClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                String num = getString(R.string.dbs_contact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
                startActivity(intentCall);
            } else if (btnClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
                String num1 = getString(R.string.ocbc_contact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num1));
                startActivity(intentCall);
            } else if (btnClicked.equalsIgnoreCase(getString(R.string.uob))) {
                String num2 = getString(R.string.uob_contact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num2));
                startActivity(intentCall);
            }
            return true;

        } else if (id == R.id.ToggleFavouriteSelection) {
            if (btnClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                if (btnDBS.getCurrentTextColor() == Color.parseColor("#DBE9F3")) {
                    btnDBS.setTextColor(Color.parseColor("#CC0003"));

                } else if (btnDBS.getCurrentTextColor() == Color.parseColor("#CC0003")) {
                    btnDBS.setTextColor(Color.parseColor("#DBE9F3"));
                }
            } else if (btnClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
                if (btnOCBC.getCurrentTextColor() == Color.parseColor("#DBE9F3")) {
                    btnOCBC.setTextColor(Color.parseColor("#CC0003"));

                } else if (btnOCBC.getCurrentTextColor() == Color.parseColor("#CC0003")) {
                    btnOCBC.setTextColor(Color.parseColor("#DBE9F3"));
                }


            } else if (btnClicked.equalsIgnoreCase(getString(R.string.uob))) {
                if (btnUOB.getCurrentTextColor() == Color.parseColor("#DBE9F3")) {
                    btnUOB.setTextColor(Color.parseColor("#CC0003"));

                } else if (btnUOB.getCurrentTextColor() == Color.parseColor("#CC0003")) {
                    btnUOB.setTextColor(Color.parseColor("#DBE9F3"));
                }


            }
        }


            return super.onContextItemSelected(item);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText(getString(R.string.dbs));
            btnOCBC.setText(getString(R.string.ocbc));
            btnUOB.setText(getString(R.string.uob));
            tvTitle.setText(getString(R.string.local_banks_in_singapore));
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText(R.string.dbs_chi);
            btnOCBC.setText(R.string.ocbc_chi);
            btnUOB.setText(R.string.uob_chi);
            tvTitle.setText(R.string.local_banks_in_singapore_chi);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}