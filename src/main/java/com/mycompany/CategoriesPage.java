package com.mycompany;

import com.mycompany.entites.Category;
import com.mycompany.services.CategoryService;
import com.mycompany.services.ServiceRegistry;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.List;

public class CategoriesPage extends BaseWebPage {
    public CategoriesPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        final List<Category> categoryList = new ArrayList<>(ServiceRegistry.get(CategoryService.class).listAll());
        final ListView<Category> categories = new ListView<Category>("categories", categoryList) {
            @Override
            protected void populateItem(ListItem<Category> listItem) {
                listItem.add(new Label("name", listItem.getModelObject().getName()));
                final AttributeAppender srcApender = new AttributeAppender("src", listItem.getModelObject().getImageUrl());
                listItem.add(new WebMarkupContainer("image").add(srcApender));

            }
        };
        add(categories);
    }
}
