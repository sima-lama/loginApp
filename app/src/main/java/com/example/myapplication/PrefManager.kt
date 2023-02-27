package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences


class PrefManager constructor(context: Context) {

        companion object {
            @Volatile
            private var INSTANCE: PrefManager? = null

            fun getInstance(context: Context): PrefManager {
                return INSTANCE ?: synchronized(this) {
                    INSTANCE ?: PrefManager(context.applicationContext).also { INSTANCE = it }
                }
            }
        }

        private val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        fun putString(key: String, value: String) {
            sharedPreferences.edit().putString(key, value).apply()
        }

        fun getString(key: String, defaultValue: String): String {
            return sharedPreferences.getString(key, defaultValue) ?: defaultValue
        }

        // add other methods to put and get other types of data

    }
