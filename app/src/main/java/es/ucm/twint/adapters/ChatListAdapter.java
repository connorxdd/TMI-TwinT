package es.ucm.twint.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.ucm.mocks.ChatListItem;
import es.ucm.mocks.Perfil;
import es.ucm.twint.R;

public class ChatListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<ChatListItem> chatListItems;

    public ChatListAdapter(Context context, ArrayList<ChatListItem> chatListItems) {
        this.context = context;
        this.chatListItems = chatListItems;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return chatListItems.size();
    }

    @Override
    public Object getItem(int i) {
        return chatListItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.chat_list_item, viewGroup, false);
        ChatListItem chatListItem = (ChatListItem) getItem(i);

        TextView tv_nombre_apellido = (TextView) rowView.findViewById(R.id.tv_nombre_apelido_usuario);
        ImageView iv_usuario = (ImageView) rowView.findViewById(R.id.iv_usuario);
        TextView tv_num_msg = (TextView) rowView.findViewById(R.id.tv_numero_msj_nuevos);

        iv_usuario.setClipToOutline(true);

        if(chatListItem.getSurname()!=null && chatListItem.getSurname()!="") tv_nombre_apellido.setText(chatListItem.getName()+" "+chatListItem.getSurname());
        else tv_nombre_apellido.setText(chatListItem.getName());
        if(chatListItem.getPendingMessages()==0) {
            tv_num_msg.setVisibility(View.INVISIBLE);
        }else{
            tv_num_msg.setText(chatListItem.getPendingMessages().toString());
        }
        if(chatListItem.getProfileImage()!=null && chatListItem.getProfileImage()!="") Picasso.get().load(chatListItem.getProfileImage()).into(iv_usuario);

        return rowView;
    }
}