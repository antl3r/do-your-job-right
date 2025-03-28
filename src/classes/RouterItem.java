package classes;

import interfaces.IRouterCallback;

/**
 * Represents a router item with a title and a callback.
 * 
 * <p>Router callbacks are expected to return a boolean value:
 * - Returning {@code true} will break a display loop.
 * - Returning {@code false} will allow the loop to continue.
 * </p>
 */
public class RouterItem {
    /**
     * The title of the router item.
     */
    private String title;

    /**
     * The callback associated with the router item.
     */
    private IRouterCallback callback;

    /**
     * Constructs a RouterItem with the specified title and callback.
     * 
     * @param title The title of the router item.
     * @param callback The callback associated with the router item.
     */
    public RouterItem(String title, IRouterCallback callback) {
        this.title = title;
        this.callback = callback;
    }

    /**
     * Gets the title of the router item.
     * 
     * @return The title of the router item.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the callback associated with the router item.
     * 
     * @return The callback associated with the router item.
     */
    public IRouterCallback getCallback() {
        return callback;
    }
}

