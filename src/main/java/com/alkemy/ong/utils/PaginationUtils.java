package com.alkemy.ong.utils;

import com.alkemy.ong.models.entity.ContactEntity;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Setter
public class PaginationUtils {
    private Integer page;
    private static final Integer PAGE_NUMBER = 0;
    private Integer size;
    private static final Integer PAGE_SIZE = 5;
    private String path;
    private Page<?> pageObject;

    /**
     * Constructor to use query with pagination
     *
     * @param repository receives an object of type JpaRepository
     * @param page receives an integer value to indicate the page number
     * @param path receives a string value to indicate the path of the page
     */
    public PaginationUtils(JpaRepository repository, Optional<Integer> page, Optional<Integer> size, String path) {
        Pageable getPageWithSizeElements = PageRequest.of(PAGE_NUMBER, PAGE_SIZE);
        this.path = path;
        if (page.isPresent() && size.isPresent()) {
            getPageWithSizeElements = PageRequest.of(page.get() - 1, size.get());
            this.page = page.get();
            this.size = size.get();
        } else if (page.isPresent()) {
            getPageWithSizeElements = PageRequest.of(page.get() - 1, PAGE_SIZE);
            this.page = page.get();
            this.size = PAGE_SIZE;
        }
        else if (size.isPresent()) {
            getPageWithSizeElements = PageRequest.of(PAGE_NUMBER, size.get());
            this.size = size.get();
            this.page = PAGE_NUMBER+1;
        }
        else {
            this.size = PAGE_SIZE;
            this.page = PAGE_NUMBER+1;
        }
        this.pageObject = repository.findAll(getPageWithSizeElements);
    }


    /**
     * Method to get the page object
     *
     * @return a page object
     */
    public Page<?> getPage() {
        return pageObject;
    }

    /**
     * Method to get the previous page url
     *
     * @return a string value
     */
    public String getPrevious() {
        if(pageObject.hasPrevious() && pageObject.hasContent()){
            return String.format(path, page-1, size);
        }
        return null;
    }

    /**
     * Method to get the next page url
     *
     * @return a string value
     */
    public String getNext() {
        if(pageObject.hasNext()){
            return String.format(path, page+1, size);
        }
        return null;
    }
}