package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.jpa_controllers.NewsJpaController;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("newsBacking")
@RequestScoped
public class NewsBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(NewsBackingBean.class);

    @Inject
    private NewsJpaController newsJpaController;

    private News news;

    /**
     * News feed created if it does not exist.
     *
     * @return
     */
    public News getNews() {
        if (news == null) {
            news = new News();
        }
        return news;
    }

    /**
     * Save the current news feed to the db
     *
     * @return
     * @throws Exception
     */
    public String createNews() throws Exception {
        newsJpaController.create(news);
        return null;
    }
    
    /**
     * Marks a news feed as removed (changes removal status to true)
     * @param news
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public void removeNews(News news) throws Exception {
        news.setIsRemoved(true);
        news.setLastModified(new Date());
        newsJpaController.edit(news);
    }
    
    /**
     * Marks a news feed as not removed (changes removal status to false)
     * @param news
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public void addNews(News news) throws Exception {
        news.setIsRemoved(false);
        news.setLastModified(new Date());
        newsJpaController.edit(news);
    }
    
    /**
     * If 1 news feeds is already enabled to display on the front page, all other news feeds will be disabled and be
     * unable to be displayed. Ensures that one news feed is enabled at all times. In short, this method
     * guarantees that 1 news feed is enabled at all times.
     * @param news
     * @return 
     * By: Giancarlo Biasiucci
     */
    public boolean decideDisabled(News news)
    {   
        return !news.getIsRemoved();
    }
    
    /**
     * Determines whether a news feed should be added or removed based on its current removal status
     * whenever the corresponding link in the managerial news page is clicked
     * (changed to other state, if true than changed to false and vice versa)
     * @param news
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String addOrRemoveNews(News news) throws Exception
    {
        LOG.debug("Enabled feed: " + newsJpaController.getEnabledNews().getRSSFeed());
        removeNews(newsJpaController.getEnabledNews());
        LOG.debug("Added news: " + news.getRSSFeed());
        addNews(news);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerNews.xhtml");
        return null;
    }
    
    /**
     * Returns a String indicating what will occur when the corresponding link in the managerial
     * news page is clicked
     * @param isRemoved
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved)
        {
            return "Enable News";
        }
        else
        {
            return "Enabled";
        }
    }
}
