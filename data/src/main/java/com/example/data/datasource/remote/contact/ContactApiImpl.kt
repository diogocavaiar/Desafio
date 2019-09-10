package com.example.data.datasource.remote.contact

import com.example.data.entity.contacts.ContactsResponse
import io.reactivex.Observable

class ContactApiImpl : ContactApi {
    override fun getContacts(): Observable<MutableList<ContactsResponse>> {
        val listContactsResponse = mutableListOf(ContactsResponse("Dwayne Johnson",
            "18 99999-9999", "http://image.tmdb.org/t/p/w185/kuqFzlYMc2IrsOyPznMd1FroeGq.jpg", "1"),
            ContactsResponse("Jason Statham",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/PhWiWgasncGWD9LdbsGcmxkV4r.jpg", "2"),
            ContactsResponse("Idris Elba",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/be1bVF7qGX91a6c5WeRPs5pKXln.jpg", "3"),
            ContactsResponse("Vanessa Kirby",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/9itJW9EjTS4tXHa02LusOgX8vdN.jpg", "4"),
            ContactsResponse("Eiza González",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/2EpyDXqw1oyJnKayu2XshczjiBN.jpg", "5"),
            ContactsResponse("Eddie Marsan",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/zcJ2W9BuiBPohtOkPFcYuFfCzji.jpg", "6"),
            ContactsResponse("Stephanie Vogt",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/2rX4MAbp5Kdv7AV5DZYv7iVd9yU.jpg", "7"),
            ContactsResponse("David Mumeni",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/tWt0hxigKzGu3zs0DFhhmRjoXZw.jpg", "8"),
            ContactsResponse("Axel Nu", "18 99999-9999", "", "9"),
            ContactsResponse("Lampros Kalfuntzos",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/FhYiUP9OWdN6T8j3ZlUKBfqylx.jpg", "10"),
            ContactsResponse("Leati Joseph Anoaʻi",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/tSQg6XQUaAhXfdMT2EOxJjuTqnV.jpg", "11"),
            ContactsResponse("Kevin Hart",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/9zxRAhWMxhVrgDnUysvTGLW7fcW.jpg", "12"),
            ContactsResponse("Ryan Reynolds",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/vYxl6lGbVPr7f8QlaSdeRLUs5PB.jpg", "13"),
            ContactsResponse("Rob Delaney",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/jTzMa3UCLpuyIlHvFfZo2gJsmg2.jpg", "14"),
            ContactsResponse("Cliff Curtis",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/wKeQvFh7z1QwsiJEmZgva83Lp5q.jpg", "15"),
            ContactsResponse("Helen Mirren",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/usuAZSSIYqBviO2eACXIiQpYpMW.jpg", "16"),
            ContactsResponse("Eliana Su’a", "18 99999-9999", "", "17"),
            ContactsResponse("Lori Pelenise Tuisano", "18 99999-9999", "", "18"),
            ContactsResponse("Chris Morgan",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/dUGxIwFBLrSFLImxjeda1krndMO.jpg", "19"),
            ContactsResponse("David Leitch",
                "18 99999-9999", "http://image.tmdb.org/t/p/w185/eVSgvAIsP6mwuVbbhVb4HkVvmsu.jpg", "20"))

        return Observable.just(listContactsResponse)
    }
}