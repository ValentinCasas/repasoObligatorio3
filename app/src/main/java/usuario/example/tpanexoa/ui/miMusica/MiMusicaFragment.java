package usuario.example.tpanexoa.ui.miMusica;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import usuario.example.tpanexoa.Models.AudioService;
import usuario.example.tpanexoa.R;

public class MiMusicaFragment extends Fragment {

    private MiMusicaViewModel mViewModel;
    private Button btnReproducir;

    public static MiMusicaFragment newInstance() {
        return new MiMusicaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mi_musica, container, false);
        btnReproducir = rootView.findViewById(R.id.btnReproducir);
        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia el servicio para reproducir el audio
                Intent intent = new Intent(getActivity(), AudioService.class);
                getActivity().startService(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MiMusicaViewModel.class);
        // TODO: Use the ViewModel
    }
}
