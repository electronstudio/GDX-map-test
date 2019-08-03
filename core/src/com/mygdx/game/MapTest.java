package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapTest extends ApplicationAdapter {
	private SpriteBatch batch;
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	private OrthographicCamera cam;

	@Override
	public void create () {
		batch = new SpriteBatch();
		map = (new TmxMapLoader()).load("maptest.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, 1f, batch);
		cam = new OrthographicCamera(400,200);
		cam.translate(200,100);
		cam.update();
		mapRenderer.setView(cam);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mapRenderer.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		map.dispose();
	}
}
