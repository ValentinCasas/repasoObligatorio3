package usuario.example.tpanexoa.ui.llamar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import usuario.example.tpanexoa.databinding.FragmentLlamarBinding;

public class LlamarFragment extends Fragment {

    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;

    private FragmentLlamarBinding binding;

    public static LlamarFragment newInstance() {
        return new LlamarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLlamarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button enviarButton = binding.btnEnviar;
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroTelefonico = binding.etNumeroTelefonico.getText().toString();
                if (numeroTelefonico == null || numeroTelefonico.trim().isEmpty()) {
                    Toast.makeText(getContext(), "Por favor ingrese un número telefónico válido", Toast.LENGTH_SHORT).show();
                } else {
                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                    } else {
                        hacerLlamada(numeroTelefonico);
                    }
                }
            }
        });
    }

    private void hacerLlamada(String numeroTelefonico) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + numeroTelefonico));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL_PHONE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String numeroTelefonico = binding.etNumeroTelefonico.getText().toString();
                hacerLlamada(numeroTelefonico);
            } else {
                Toast.makeText(getContext(), "Permiso denegado para hacer una llamada telefónica", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

