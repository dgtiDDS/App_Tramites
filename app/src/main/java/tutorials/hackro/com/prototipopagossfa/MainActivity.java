package tutorials.hackro.com.prototipopagossfa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.antecedentes_tipo_persona_lbl)
    Spinner antecedentesTipoPersonaLbl;
    @BindView(R.id.antecedentes_nombre_lbl)
    AutoCompleteTextView antecedentesNombreLbl;
    @BindView(R.id.antecedentes_apellido_paterno_lbl)
    AutoCompleteTextView antecedentesApellidoPaternoLbl;
    /*@BindView(R.id.antecedentes_curp_lbl)
    AutoCompleteTextView antecedentesCurpLbl;*/
    @BindView(R.id.antecedentes_curp_lbl)
    AutoCompleteTextView antecedentesCurpLbl;
    @BindView(R.id.antecedentes_rfc_lbl)
    AutoCompleteTextView antecedentesRfcLbl;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


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


    }
}
