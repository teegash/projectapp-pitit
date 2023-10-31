package com.nate.pitit

import com.nate.pitit.models.Category
import com.nate.pitit.models.Expense
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

val config = RealmConfiguration.create(schema = setOf(Expense::class, Category::class))
val db: Realm = Realm.open(config)