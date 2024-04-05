package com.example.mirea;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mirea.R;
import java.util.Objects;

public class StartFragment extends Fragment {

    private final String ID = "channelID";
    private final int notificationId = 10;

    public StartFragment() {
        super(R.layout.fragment_start);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(ID, "Chanel_1", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Chanel 1");
            NotificationManager notificationManager = (NotificationManager)requireContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        view.findViewById(R.id.toListFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = "Данные, переданные из StartFragment в ListFragment";
                bundle.putString("listKey", result);
                Navigation.findNavController(v).navigate(R.id.from_start_to_list, bundle);
            }
        });

        view.findViewById(R.id.toRecyclerFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = "Данные, переданные из StartFragment в RecyclerFragment";
                bundle.putString("recyclerKey", result);
                Navigation.findNavController(v).navigate(R.id.from_start_to_recycler, bundle);
            }
        });


        view.findViewById(R.id.notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("MIREA")
                        .setContentText("Hello World")
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
                    return;
                notificationManager.notify(notificationId, builder.build());
            }
        });

        return view;
    }
}