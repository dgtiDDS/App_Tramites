package tutorials.hackro.com.prototipopagossfa;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Presenters.antecedentesPresenter;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Views.antecedentesView;
import tutorials.hackro.com.prototipopagossfa.Presenters.antecedentesPresenterImpl;
import tutorials.hackro.com.prototipopagossfa.Views.payment;

public class MainActivity extends AppCompatActivity implements antecedentesView {


    @BindView(R.id.antecedentes_cantidad_lbl)
    EditText antecedentesCantidadLbl;
    @BindView(R.id.antecedentes_tipo_persona_lbl)
    Spinner antecedentesTipoPersonaLbl;
    @BindView(R.id.div_dataGeneral)
    View divDataGeneral;
    @BindView(R.id.antecedentes_nombre_lbl)
    AutoCompleteTextView antecedentesNombreLbl;
    @BindView(R.id.antecedentes_apellido_paterno_lbl)
    AutoCompleteTextView antecedentesApellidoPaternoLbl;
    @BindView(R.id.div_dataPersonal)
    View divDataPersonal;
    @BindView(R.id.antecedentes_curp_lbl)
    AutoCompleteTextView antecedentesCurpLbl;
    @BindView(R.id.div_datarfc)
    View divDatarfc;
    @BindView(R.id.antecedentes_calle_lbl)
    AutoCompleteTextView antecedentesCalleLbl;
    @BindView(R.id.antecedentes_numero_exterior_lbl)
    AutoCompleteTextView antecedentesNumeroExteriorLbl;
    @BindView(R.id.antecedentes_numero_interior_lbl)
    AutoCompleteTextView antecedentesNumeroInteriorLbl;
    @BindView(R.id.antecedentes_municipio_lbl)
    AutoCompleteTextView antecedentesMunicipioLbl;
    @BindView(R.id.antecedentes_localidad_lbl)
    AutoCompleteTextView antecedentesLocalidadLbl;
    @BindView(R.id.antecedentes_cp_lbl)
    AutoCompleteTextView antecedentesCpLbl;
    @BindView(R.id.antecedentes_colonia_lbl)
    AutoCompleteTextView antecedentesColoniaLbl;
    @BindView(R.id.antecedentes_otra_colonia_lbl)
    AutoCompleteTextView antecedentesOtraColoniaLbl;
    @BindView(R.id.div_dataDirection)
    View divDataDirection;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.antecedentes_apellido_materno_lbl)
    AutoCompleteTextView antecedentesApellidoMaternoLbl;
    @BindView(R.id.antecedentes_importe_lbl)
    TextView antecedentesImporteLbl;


    private Dialog customDialog, timeWait;
    private antecedentesPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new antecedentesPresenterImpl(this);

        getSupportActionBar().setTitle("CARTA DE NO ANTECEDENTES PENALES");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipoPersona, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        antecedentesTipoPersonaLbl.setAdapter(adapter);


        String[] municipios = getResources().getStringArray(R.array.municipios_arrays);
        ArrayAdapter<String> adaptersMunicipios = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, municipios);
        antecedentesMunicipioLbl.setAdapter(adaptersMunicipios);


        String[] localidades = getResources().getStringArray(R.array.localidades_array);
        ArrayAdapter<String> adaptersLocalidades = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, localidades);
        antecedentesLocalidadLbl.setAdapter(adaptersLocalidades);


        String[] colonias = getResources().getStringArray(R.array.colonias_array);
        ArrayAdapter<String> adaptersColonias = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colonias);
        antecedentesColoniaLbl.setAdapter(adaptersColonias);

        setErrorAntecedentes_tipo_persona_lbl();

        customDialog = new Dialog(this, R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(false);
        customDialog.setContentView(R.layout.dialog_confirmation_data);

        timeWait = new Dialog(this, R.style.Theme_Dialog_Translucent);
        timeWait.requestWindowFeature(Window.FEATURE_NO_TITLE);
        timeWait.setCancelable(false);
        timeWait.setContentView(R.layout.dialog_time_wait);

    }


    //******************************************************************************************//
    //Botones
    @OnClick(R.id.button)
    public void onClick() {

        presenter.validateFields(
                antecedentesCantidadLbl.getText().toString(),
                antecedentesImporteLbl.getText().toString(),
                String.valueOf(antecedentesTipoPersonaLbl.getSelectedItemPosition()),
                antecedentesNombreLbl.getText().toString(),
                antecedentesApellidoPaternoLbl.getText().toString(),
                antecedentesApellidoMaternoLbl.getText().toString(),
                antecedentesCurpLbl.getText().toString(),
                antecedentesCalleLbl.getText().toString(),
                antecedentesNumeroExteriorLbl.getText().toString(),
                antecedentesNumeroInteriorLbl.getText().toString(),
                antecedentesMunicipioLbl.getText().toString(),
                antecedentesLocalidadLbl.getText().toString(),
                antecedentesCpLbl.getText().toString(),
                antecedentesColoniaLbl.getText().toString(),
                antecedentesOtraColoniaLbl.getText().toString()

        );
    }


    public void aceptarDialog(View v) {
        Toast.makeText(this, "dwedew", Toast.LENGTH_SHORT).show();
        finish();
        navigateToPayment();
    }


    public void cancelarDialog(View v) {
        Toast.makeText(this, "dwedew", Toast.LENGTH_SHORT).show();
        customDialog.hide();
    }


//******************************************************************************************//

    @Override
    public void showProgress() {
        timeWait.show();
    }

    @Override
    public void hideProgress() {
        timeWait.hide();
    }

    @Override
    public void showDialog() {
        customDialog.show();
    }

    @Override
    public void hideDialog() {
        customDialog.hide();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setErrorAntecedentes_tipo_persona_lbl() {
        try {
            ((TextView) antecedentesTipoPersonaLbl.getSelectedView()).setError("Error");
        } catch (Exception e) {
            Log.e("Eror", "Error");
        }
    }

    @Override
    public void setErrorAntecedentes_apellido_paterno_lbl() {
        antecedentesApellidoPaternoLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_apellido_materno_lbl() {

    }

    @Override
    public void setErrorAntecedentes_curp_lbl() {
        antecedentesCurpLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_calle_lbl() {
        antecedentesCalleLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_numero_exterior_lbl() {
        antecedentesNumeroExteriorLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_numero_interior_lbl() {
        antecedentesNumeroInteriorLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_municipio_lbl() {
        antecedentesMunicipioLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_localidad_lbl() {
        antecedentesLocalidadLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_cp_lbl() {
        antecedentesCpLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_colonia_lbl() {
        antecedentesColoniaLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_otra_colonia_lbl() {
        antecedentesOtraColoniaLbl.setError(getResources().getString(R.string.campo_obligatorio));
    }

    @Override
    public void setErrorAntecedentes_nombre() {
        antecedentesNombreLbl.setError(getResources().getString(R.string.campo_obligatorio));

    }

    @Override
    public void navigateToPayment() {
        startActivity(new Intent(MainActivity.this, payment.class));
    }


}
