package com.example.songr;

import com.example.songr.models.AlbumsTable;
import com.example.songr.models.*;
import com.example.songr.repositores.AlbumTableRepository;
import com.example.songr.repositores.SongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SongrApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AlbumTableRepository albumTableRepository;

	@Autowired
	private SongRepository songRepository;

	@Test
	public void testCreateAlbum() throws Exception {
		mockMvc.perform(post("/create-album")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("title", "New Album")
						.param("artist", "Artist Name")
						.param("songCount", "10")
						.param("length", "300")
						.param("imageUrl", "album_image.jpg")
				)
				.andExpect(status().is3xxRedirection())

				.andExpect(redirectedUrl("/"));

	}

	@Test
	public void testAccessAlbumSongs() throws Exception {
		AlbumsTable album = new AlbumsTable("Test Album", "Test Artist", 8, 240, "album_image.jpg");
		albumTableRepository.save(album);

		Song song1 = new Song("Song 1", 180, 1, album);
		Song song2 = new Song("Song 2", 210, 2, album);
		songRepository.save(song1);
		songRepository.save(song2);

		mockMvc.perform(get("/songs/{id}", album.getId()))
				.andExpect(status().isOk())
				.andExpect(view().name("songs.html"))
				.andExpect(model().attribute("Songs", hasSize(2)))
				.andExpect(model().attribute("Songs", hasItem(
						allOf(
								hasProperty("title", is("Song 1")),
								hasProperty("length", is(180)),
								hasProperty("trackNumber", is(1))
						)
				)))
				.andExpect(model().attribute("Songs", hasItem(
						allOf(
								hasProperty("title", is("Song 2")),
								hasProperty("length", is(210)),
								hasProperty("trackNumber", is(2))
						)
				)));

	}
}
