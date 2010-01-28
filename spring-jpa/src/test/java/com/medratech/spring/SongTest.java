package com.medratech.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.medratech.spring.dao.impl.SongDao;
import com.medratech.spring.model.impl.Song;

@ContextConfiguration(locations={"/jpa-context.xml"})
public class SongTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource
    private SongDao songDao;
    
	@Test
    public void testSave() {
        createAndSaveSong("The Who", "Baba O'Riley");
        
        //assertEquals(1, countRowsInTable("song"));

        Song transientSong = getLastSong();
        assertEquals("Artist not saved correctly", "The Who", transientSong.getArtist());
        assertEquals("Title not saved correctly", "Baba O'Riley", transientSong.getTitle());
    }

    @Test
    public void testGetById() {
    	createAndSaveSong("The Who", "Baba O'Riley");
    	Song transientSong = getLastSong();
        
        Song foundSong = songDao.findById(transientSong.getId());
        
        assertEquals(transientSong.getArtist(), foundSong.getArtist());
        assertEquals(transientSong.getTitle(), foundSong.getTitle());
    }

    @Test
    public void testDelete() {
    	createAndSaveSong("The Who", "Baba O'Riley");
    	Song transientSong = getLastSong();
        System.out.println(transientSong.getId());
    	Song song = songDao.findById(transientSong.getId());
    	
        songDao.remove(song);
        songDao.flush();
        //assertEquals("Deleting song failed.", 0, countRowsInTable("song"));
    }

    
    @Test
    public void testUpdate() {
    	createAndSaveSong("The Who", "Baba O'Riley");
    	Song transientSong = getLastSong();
        
    	Song song = songDao.findById(transientSong.getId());
    	//assertEquals("The song didn't get saved.", 1,countRowsInTable("song"));

    	Long oldVersion = song.getVersion();
    	
        song.setGenre("Classic Rock");
    	
        songDao.persist(song);
        songDao.flush();

        transientSong = getLastSong();
        //assertEquals(1, countRowsInTable("song"));
        assertEquals("The genre didn't get changed", "Classic Rock", song.getGenre());
        assertNotSame("The version didn't get changed", oldVersion, transientSong.getVersion());
    }

    private void createAndSaveSong(String artist, String title) {
        Song song = new Song();
        song.setArtist(artist);
        song.setTitle(title);
        songDao.persist(song);
        songDao.flush();
    }
    
    private Song getLastSong() {
        return simpleJdbcTemplate.queryForObject(
                "select * from song order by id desc limit 1", new SongRowMapper());
    }
    private static class SongRowMapper implements ParameterizedRowMapper<Song> {
        public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
            Song result = new Song();
            result.setId(rs.getLong("id"));
            result.setTitle(rs.getString("title"));
            result.setArtist(rs.getString("artist"));
            result.setGenre(rs.getString("genre"));
            result.setVersion(rs.getLong("version"));
            return result;
        }
    }
}