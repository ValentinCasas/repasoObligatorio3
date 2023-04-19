package usuario.example.tpanexoa;

import android.app.Application;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

public class LogginActivityViewModel extends AndroidViewModel {
    private List<Pair<String, String>> users;

    public LogginActivityViewModel(@NonNull Application application) {
        super(application);
        users = new ArrayList<>();
        // Agregar algunos usuarios
        users.add(new Pair<>("usuario1", "contraseña1"));
        users.add(new Pair<>("usuario2", "contraseña2"));
        users.add(new Pair<>("usuario3", "contraseña3"));
    }

    // Resto del código


    private String usuario;
    private String contrasenia;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean Validado() {
        for (Pair<String, String> user : users) {
            if (usuario.equals(user.first) && contrasenia.equals(user.second)) {
                return true;
            }
        }
        return false;
    }
}


