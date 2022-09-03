package com.tosan.bookstore;

import com.tosan.bookstore.exceptions.BookStoreFaults;

public final class LocaleService {
    public static String GetMessage(BookStoreFaults faults)
    {
        return faults.getDescription();
    }
}
