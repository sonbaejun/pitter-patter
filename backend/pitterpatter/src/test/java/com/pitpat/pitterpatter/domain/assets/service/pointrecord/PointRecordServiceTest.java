package com.pitpat.pitterpatter.domain.assets.service.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.CreatePointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.FindPointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.PointRecordSearchCondition;
import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.PointRecord;
import com.pitpat.pitterpatter.entity.enums.Gender;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PointRecordServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    PointRecordService pointRecordService;

    private Long child1Id;
    private Long child2Id;

    @BeforeEach
    public void init() {
        Child child1 = Child.builder()
                .nickname("Child1")
                .gender(Gender.MALE)
                .created_at(LocalDate.now())
                .updated_at(LocalDate.now())
                .birth(LocalDate.of(2015, 1, 1))
                .personal_record(10)
                .point(100)
                .build();

        Child child2 = Child.builder()
                .nickname("Child2")
                .gender(Gender.FEMALE)
                .created_at(LocalDate.now())
                .updated_at(LocalDate.now())
                .birth(LocalDate.of(2016, 2, 2))
                .personal_record(20)
                .point(200)
                .build();

        em.persist(child1);
        em.persist(child2);

        child1Id = child1.getId();
        child2Id = child2.getId();

        pointRecordService.createPointRecord(new CreatePointRecordDto(10, "Test Source 1", child1));
        pointRecordService.createPointRecord(new CreatePointRecordDto(20, "Test Source 2", child2));
        pointRecordService.createPointRecord(new CreatePointRecordDto(30, "Test Source 3", child1));
        pointRecordService.createPointRecord(new CreatePointRecordDto(40, "Test Source 4", child2));
        pointRecordService.createPointRecord(new CreatePointRecordDto(50, "Test Source 5", child1));
    }

    @Test
    public void testCreatePointRecord() {
        Child child = em.find(Child.class, child1Id);
        CreatePointRecordDto createPointRecordDto = new CreatePointRecordDto(60, "Test Source 6", child);
        PointRecord pointRecord = pointRecordService.createPointRecord(createPointRecordDto);

        assertNotNull(pointRecord.getId());
        assertEquals(60, pointRecord.getAmount());
        assertEquals("Test Source 6", pointRecord.getSource());
        assertEquals(child, pointRecord.getChild());
    }

    @Test
    public void testFindPointByChild() {
        Integer totalPoints = pointRecordService.findPointByChild(child1Id);
        assertNotNull(totalPoints);
        // Here you would need to sum the actual points for the expected result
        assertEquals(90, totalPoints);
    }

    @Test
    public void testFindPointRecordsByChild() {
        List<FindPointRecordDto> pointRecords = pointRecordService.findPointRecordsByChild(child1Id);
        assertNotNull(pointRecords);
        assertEquals(3, pointRecords.size());
        assertEquals(10, pointRecords.get(0).getAmount());
        assertEquals(30, pointRecords.get(1).getAmount());
        assertEquals(50, pointRecords.get(2).getAmount());
    }

    // This test requires implementation of the findPointRecordByConditions method
    @Test
    public void testFindPointRecordByConditions() {
        // Implement your condition here
        PointRecordSearchCondition condition = new PointRecordSearchCondition();
        // Set conditions as required

        List<FindPointRecordDto> pointRecords = pointRecordService.findPointRecordByConditions(condition, child1Id);
        // Add appropriate assertions based on the condition
        assertNotNull(pointRecords);
        // Example assertion
        assertEquals(3, pointRecords.size());
    }
}
