package com.example.start;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.start.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RelativeLayout chatLL;
    private ImageButton btnSend;
    private ImageButton btnEmoji;
    private ImageButton btnBackToMenu;
    private ImageButton btnAdd;
    private TextView Name;
    private EditText msg;
    private String isauthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //
        //Имя Пользователя
        //
        //author = binding.authorname.getText().toString();
        //
        //Лэйауты
        //
        chatLL = binding.chatLayout;
        //
        //Кнопки
        //
        btnSend = binding.btnSend;
        btnEmoji = binding.btnEmoji;
        btnBackToMenu = binding.btnBackToMenu;
        btnAdd = binding.btnAdd;
        //
        //Вьюшки
        //
        Name = binding.name;
        msg = binding.message;

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("Марк", "HI", 10, "left"));

        MessagesAdapter messagesAdapter = new MessagesAdapter(messages);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerView.setAdapter(messagesAdapter);
        //binding.recyclerView.addItemDecoration();
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                if (binding.authorname.getText().toString().equals("Я")){
                    isauthor = "right";
                }else {
                    isauthor = "left";
                }
                messagesAdapter.addMessage(new Message("Марк", binding.message.getText().toString(), 10, isauthor));
                msg.setText("");
            }
        });
    }
}