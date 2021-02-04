package com.neueda.java.assignment.urlshortner.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO;
import com.neueda.java.assignment.urlshortner.model.Statistic;


@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    @Query("select count(s.id) from Statistic s")
	Long getNumberOfHits();
	
    @Query("select count(s.id) from Statistic s where s.url.shortUrl = :shortUrl")
	Long getNumberOfHitsByCode(@Param("shortUrl") String shortUrl);
	
    @Query("select new com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO(s.browser, count(s)) from Statistic s group by s.browser")
    List<StatisticsDTO> getBrowsers();

    @Query("select new com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO(s.deviceType, count(s)) from Statistic s group by s.deviceType")
    List<StatisticsDTO> getDevicesTypes();

    @Query("select new com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO(s.operatingSystem, count(s)) from Statistic s group by s.operatingSystem")
    List<StatisticsDTO> getOperatingSystems();

    @Query("select new com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO(s.browser, count(s)) from Statistic s where s.url.shortUrl = :shortUrl group by s.browser")
    List<StatisticsDTO> getBrowsersByCode(@Param("shortUrl") String shortUrl);

    @Query("select new com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO(s.deviceType, count(s)) from Statistic s where s.url.shortUrl = :shortUrl group by s.deviceType")
    List<StatisticsDTO> getDevicesTypesByCode(@Param("shortUrl") String shortUrl);

    @Query("select new com.neueda.java.assignment.urlshortner.Dto.StatisticsDTO(s.operatingSystem, count(s)) from Statistic s where s.url.shortUrl = :shortUrl group by s.operatingSystem")
	List<StatisticsDTO> getOperatingSystemsByCode(@Param("shortUrl") String shortUrl);
}
