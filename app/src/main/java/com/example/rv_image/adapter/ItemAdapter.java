package com.example.rv_image.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rv_image.databinding.ItemListDataBinding;
import com.example.rv_image.model.Item;

import java.util.List;


// PASO 4 EXTENDER DE RV VIEW Y CARGAR CLASE ITEMVIEWHOLDER
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    // PASO 5 REFERENCIAR VARIABLES QUE ESTA EN EL FRAGMENTO CON LOS DATOS

    private List<Item> itemList;
    private Context context;
    private SendItem listener;


    // PASO 7 GENERAR UN CONSTRUCTOR PARA CREAR OBJETOS DE ESTA CLASE

    public ItemAdapter(List<Item> itemList, Context context, SendItem sendItem) {

        this.itemList = itemList;
        this.context = context;
        this.listener = sendItem;
    }


    // PASO 7 INSTANCIAR LA CLASE BINDING INFLAR  ELEMENTOS

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding binding = ItemListDataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    //PASO 8 PASAR DATOS Y SE LOS PASAMOS A LA VISTA y seteamos los valores con los elementos de la vista

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        final Item item = itemList.get(position);
        // cargamos el textview con la descripcion
        holder.textView.setText(item.getItemDescripcion());
        // cargar imagen de la url al img view

        Glide.with(context).load(item.getUrlImage()).centerCrop().override(300, 300)
                .into(holder.imageView);
    }


    // PASO 9 CUENTA ELEMENTOS DE LA LISTA

    @Override
    public int getItemCount() {

        return itemList.size();
    }


    // 1. CREAR UNA CLASE INTERNA QUE EXTIENDE DE RECYLCERVIEW  // LUEGO IMPLEMENTAR  LA INTERFAZ VISTA

    public class ItemViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

// 2 REFERENCIAR ELEMENTOS VISUAL
        private ImageView imageView;
        private TextView textView;

       // PASO 3 REFERENCIAR NUESTRO ITEM_LIST CON SU CLASE BINDING
        public ItemViewHolder(@NonNull ItemListDataBinding binding) {
            super(binding.getRoot());

            imageView = binding.ivItem;
            textView = binding.tvItem;

            // escuchando cuando  se hacen un click en la vista
               itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            // ESCUCHAR LA SELECCION Y ME ENTREGA UNA POSICION
            listener.sendItem(itemList.get(getLayoutPosition()));
        }
    }


    // PASO 6 CREARR INTERFAZ QUE ENVIARA LOS DATOS POSTERIORMENTE

    public interface  SendItem{
        void sendItem (Item item);
    }




}
