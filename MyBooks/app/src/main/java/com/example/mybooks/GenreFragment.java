package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.adapter.GenreAdapter;
import com.example.mybooks.databinding.FragmentGenreBinding;
import com.example.mybooks.interfaces.IBookFragment;
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.retrofit.BookHttpService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreFragment extends Fragment implements IBookFragment {

    private static GenreFragment genreFragment;

    private ArrayList<Book> list = new ArrayList<>();

    private FragmentGenreBinding binding;
    private BookHttpService bookHttpService;
    private GenreAdapter adapter;

    private int page = 1;
    private boolean isRequest = true;

    public GenreFragment() {
        // Required empty public constructor
    }

    public static GenreFragment getInstance() {
        if (genreFragment == null) {
            genreFragment = new GenreFragment();
        }
        return genreFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookHttpService = BookHttpService.retrofit.create(BookHttpService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGenreBinding.inflate(inflater, container, false);
        addEventListener();
        setupRecyclerView(list);
        requestBookData(1);
        return binding.getRoot();
    }

    public void requestBookData(int themeNumber) {
        bookHttpService.getGenreList(page, themeNumber).enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {

                if (response.isSuccessful()) {
                    ArrayList<Book> addList = response.body();
                    adapter.addBookList(addList);
                    page++;
                    isRequest = true;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupRecyclerView(ArrayList<Book> list) {
        adapter = new GenreAdapter();
        adapter.initBookList(list);

        binding.genreBookContainer.setAdapter(adapter);

        binding.genreBookContainer.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {

            if (isRequest) {
                LinearLayoutManager manager = (LinearLayoutManager) binding.genreBookContainer.getLayoutManager();
                int lastVisibleBookItemCount = manager.findLastVisibleItemPosition();
                int bookTotalCount = binding.genreBookContainer.getAdapter().getItemCount() - 1;

                if (lastVisibleBookItemCount == bookTotalCount) {
                    requestBookData();
                    isRequest = false;
                }
            }
        });
    }

    private void addEventListener() {
        binding.novelButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(1); // 스프링에서 구분하는 theme 번호 넣어서 셋팅해야함
        });
        binding.mysteryButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(2);
        });
        binding.essayButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(3);
        });
        binding.selfImprovementButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(4);
        });
        binding.economyButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(5);
        });
        binding.kidButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(7);
        });
        binding.etcButton.setOnClickListener(v -> {
            adapter.formatBookList();
            requestBookData(6);
        });
    }
}