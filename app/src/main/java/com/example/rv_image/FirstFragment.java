package com.example.rv_image;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rv_image.adapter.ItemAdapter;
import com.example.rv_image.databinding.FragmentFirstBinding;
import com.example.rv_image.model.Item;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment  implements  ItemAdapter.SendItem{

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        RecyclerView recyclerView= binding.recyclerView;
        ItemAdapter adapter= new ItemAdapter(returnItemList(),getContext(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      return  binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private List<Item> returnItemList() {
        List<Item> listItem = new ArrayList<>();
        Item item01 = new Item("Zhuo Cheng you","https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640");
        listItem.add(item01);
        Item item02 = new Item("billow926","https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640");
        listItem.add(item02);
        Item item03 = new Item("Philipp Deiß","https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640");
        listItem.add(item03);
        Item item04 = new Item("Huper by Joshua Earle","https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640");
        listItem.add(item04);
        Item item05 = new Item("Melnychuk Nataliya","https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640");
        listItem.add(item05);
        Item item06 = new Item("Teagan Maddux","https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640");
        listItem.add(item06);
        Item item07 = new Item("Chen Liu","https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640");
        listItem.add(item07);
        Item item08 = new Item("John Fornander","https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640");
        listItem.add(item08);
        Item item09 = new Item("Parker Coffman","https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640");
        listItem.add(item09);
        Item item10 = new Item("XPS","https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640");
        listItem.add(item10);
        Item item11 = new Item("Daniel J. Schwarz","https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640");
        listItem.add(item11);
        Item item12 = new Item("Wesley Armstrong","https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640");
        listItem.add(item12);
        return listItem;
    }



    // AL HACE CLIK POR MEDIO DE LA INTERFAZ VIEW , ESCUCHAMOS QUE ELEMENTO SELECCIONAMOS
    // EL ONCLIK ENTREGA UNA POSICION , Y PASAMOS A LA SEGUNGA FRAGMENTO CON BUNDLE,
    // CON LA POSICION DEL ELEMENTO SELECCIONADO
    // DEBERIAMOS RECIBIR LA SELECCION QUE HICIMOS EN EL RV
    @Override
    public void sendItem(Item item) {

        Bundle bundle= new Bundle();
        bundle.putString("name",item.getItemDescripcion());
        bundle.putString("url",item.getUrlImage());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);

    }
}