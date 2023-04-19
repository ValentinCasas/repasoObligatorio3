package usuario.example.tpanexoa.ui.salir;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import usuario.example.tpanexoa.R;
import usuario.example.tpanexoa.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentSalirBinding binding;

    public static SalirFragment newInstance() {
        return new SalirFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);

        //NavigationView navView = binding.getRoot().findViewById(R.id.nav_view);
        //navView.setNavigationItemSelectedListener(this);

        return binding.getRoot();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_salirFragment) {
            mostrarDialogoDeConfirmacion(); // Llamamos al método para mostrar el diálogo
            return true; // Indicamos que la selección ha sido manejada correctamente
        }
        return false;
    }

    private void mostrarDialogoDeConfirmacion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¿Salir?");
        builder.setMessage("¿Está seguro que desea salir?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                getActivity().finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}

