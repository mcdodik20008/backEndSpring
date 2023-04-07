package backendspring.domain.product.service;

import backendspring.domain.category.model.entity.Category;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 637654257L;

    public static final QCategory category = new QCategory("category");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<backendspring.domain.subcategory.model.entity.SubCategory, backendspring.domain.product.service.QSubCategory> subCategories = this.<backendspring.domain.subcategory.model.entity.SubCategory, backendspring.domain.product.service.QSubCategory>createList("subCategories", backendspring.domain.subcategory.model.entity.SubCategory.class, backendspring.domain.product.service.QSubCategory.class, PathInits.DIRECT2);

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

