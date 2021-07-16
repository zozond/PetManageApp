package com.management.pet

typealias DataSourceListener<T> = (T) -> Unit

interface DataSource<T> {
    fun observe(listener: DataSourceListener<T>)
    fun update(block: T.() -> Unit)
    val value: T
}
