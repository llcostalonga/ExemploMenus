package br.ufes.llcostalonga.android.exemplomenus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements  PopupMenu.OnMenuItemClickListener {

    TextView txtQualquer;
    Button btQualqer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQualquer = (TextView)findViewById(R.id.txtQualquer);

        registerForContextMenu(txtQualquer);

        btQualqer = (Button) findViewById(R.id.btQualquer);


    }

    @Override //menu action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contexto_flutuante_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast;
        switch (item.getItemId()){
            case R.id.firstMenuItem:
                txtQualquer.setText("Primeiro item do menu selecionado");
                toast = Toast.makeText(this, "Nova senha enviada por e-mail!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.secondMenuItem:
                txtQualquer.setText("Segundo item do menu selecionado");
                 toast = Toast.makeText(this, "Nova senha enviada por e-mail!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
        }

        return true;

    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.firstMenuItemContextoFlutuante:
                txtQualquer.setText("");
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.firstMenuItemPopup:
                txtQualquer.setText("Primeiro item do menu POPUP selecionado");
                return true;
            case R.id.secondMenuItemPopup:
                txtQualquer.setText("Segundo item do menu POPUP selecionado");
                return true;
            default:
                return false;
        }
    }


    public void fazAlgo(View v) {
        PopupMenu popup = new PopupMenu(this, v);

        // This activity implements OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this);

        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();
    }
}
