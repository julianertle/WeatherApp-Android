package com.shashank.weatherapp.util

import androidx.lifecycle.Observer

/**
 * An [Observer] for [Event]s, simplifying the pattern of checking if the [Event]'s content has
 * already been consumed.
 *
 * [onEventUnhandledContent] is *only* called if the [Event]'s contents has not been consumed.
 */
class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(value: Event<T>) {
        // Use the 'value' parameter to access the event
        value.consume()?.let { content ->
            onEventUnhandledContent(content)
        }
    }
}
