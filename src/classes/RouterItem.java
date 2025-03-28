package classes;

import interfaces.IRouterCallback;

public class RouterItem {
    private String title;
    private IRouterCallback callback;

    public RouterItem(String title, IRouterCallback callback) {
        this.title = title;
        this.callback = callback;
    }

    public String getTitle() {
        return title;
    }

    public IRouterCallback getCallback() {
        return callback;
    }
}

