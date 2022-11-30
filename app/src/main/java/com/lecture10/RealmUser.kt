package com.lecture10

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.UUID

open class RealmUser (
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),
    var name: String? = null,
    var age: Int = 0
) : RealmObject()