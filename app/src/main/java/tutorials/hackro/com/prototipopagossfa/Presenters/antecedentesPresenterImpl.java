package tutorials.hackro.com.prototipopagossfa.Presenters;

import tutorials.hackro.com.prototipopagossfa.Interactors.antecedentesInteractorImpl;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Interactors.antecedentesInteractor;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Presenters.antecedentesPresenter;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Views.antecedentesView;
import tutorials.hackro.com.prototipopagossfa.Interfaces.antecedentesonFinishListener;

/**
 * Created by david on 25/07/16.
 */
public class antecedentesPresenterImpl implements antecedentesPresenter, antecedentesonFinishListener {


    private antecedentesView view;
    private antecedentesInteractor interactor;

    public antecedentesPresenterImpl(antecedentesView view) {
        this.view = view;
        interactor = new antecedentesInteractorImpl();
    }

    @Override
    public void validateFields(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia) {
        try {
            if (view != null) {
                view.showProgress();
            }
            interactor.validateFields(cantidad, importe, tipoPersona, nombre, paterno, materno, curp, calle, exterior, interior, municipio, localidad, cp, colonia, otraColonia, this);
        } catch (Exception e) {
            failTicket();
        }
    }

    @Override
    public void onDestroy() {
        if (view != null) {
            view = null;
        }
    }

    @Override
    public void requestData(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia) {
        try {
            interactor.responseResponse(cantidad, importe, tipoPersona, nombre, paterno, materno, curp, calle, exterior, interior, municipio, localidad, cp, colonia, otraColonia, this);
        } catch (Exception e) {
            failTicket();
        }
    }

    @Override
    public void setErrorAntecedentes_tipo_persona_lbl() {
        view.hideProgress();
        view.setErrorAntecedentes_tipo_persona_lbl();
    }

    @Override
    public void setErrorAntecedentes_apellido_paterno_lbl() {
        view.setErrorAntecedentes_apellido_paterno_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_apellido_materno_lbl() {
        view.setErrorAntecedentes_apellido_materno_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_curp_lbl() {
        view.setErrorAntecedentes_curp_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_calle_lbl() {
        view.setErrorAntecedentes_calle_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_numero_exterior_lbl() {
        view.setErrorAntecedentes_numero_exterior_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_numero_interior_lbl() {
        view.setErrorAntecedentes_numero_interior_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_municipio_lbl() {
        view.setErrorAntecedentes_municipio_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_localidad_lbl() {
        view.setErrorAntecedentes_localidad_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_cp_lbl() {
        view.setErrorAntecedentes_cp_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_colonia_lbl() {
        view.setErrorAntecedentes_colonia_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_otra_colonia_lbl() {
        view.setErrorAntecedentes_otra_colonia_lbl();
        view.hideProgress();
    }

    @Override
    public void setErrorAntecedentes_nombre() {
        view.setErrorAntecedentes_nombre();
        view.hideProgress();
    }

    @Override
    public void failTicket() {
        view.hideProgress();
        view.hideDialog();
        view.showErrorTicket();
    }

    @Override
    public void onSucess() {
        view.hideProgress();
        view.showDialog();
    }

    @Override
    public void navigateToTicket() {
        view.hideProgress();

        view.navigateToPayment();
    }


}
