package com.example.friendscircle.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friendscircle.R;
import com.example.friendscircle.activity.MyImageActivity;
import com.example.friendscircle.activity.ShowBitImgActivity;
import com.example.friendscircle.imgfile.ImgFileListActivity;

public class MyImageAdapter extends BaseAdapter {
	private Context context;
	private int position;
	private int drawable;
	private GridView gvImg;
	private boolean flag = true; // �������ֻ��ȡһ��
	private ArrayList<String> listfile = new ArrayList<String>();

	public MyImageAdapter(Context context) {
		this.context = context;
		this.notifyDataSetChanged();
	}

	public MyImageAdapter(Context context, int position, int drawable) {
		this.context = context;
		this.position = position;
		this.drawable = drawable;

		this.notifyDataSetChanged();
	}

	public void notifyData() {

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.gridview_my_image, null);
			holder.image = (ImageView) convertView.findViewById(R.id.images);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.mon = (TextView) convertView.findViewById(R.id.mon);
			holder.zan = (TextView) convertView.findViewById(R.id.zan);
			holder.howimages = (TextView) convertView
					.findViewById(R.id.how_images);
			holder.gvImg = (GridView) convertView.findViewById(R.id.gv_img);
			gvImg = holder.gvImg;
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if (position == 0) {
			holder.date.setText("����");
			holder.mon.setVisibility(View.GONE);
			holder.image.setVisibility(View.VISIBLE);
			holder.gvImg.setVisibility(View.GONE);
		} else {
			if (flag) {
				initimage();
				flag = false;
			}
			holder.zan.setText("��ӭ����");
			holder.gvImg.setAdapter(new ShowImgAdapter(context, listfile));
			holder.date.setText("28");
			holder.howimages.setText("��" + listfile.size() + "��ͼƬ");
			holder.gvImg.setVisibility(View.VISIBLE);
		}
		holder.image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(context, ImgFileListActivity.class);
				context.startActivity(intent);
				((MyImageActivity) context).finish();
			}
		});
		holder.gvImg.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(context, ShowBitImgActivity.class);
				Bundle bundle = new Bundle();
				bundle.putStringArrayList("files", listfile);
				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});

		holder.gvImg.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				deleteFilePathCache();
				notifyDataSetChanged();
				return true;
			}
		});

		holder.image.setImageResource(drawable);
		return convertView;
	}

	private static class ViewHolder {
		private ImageView image; // ͷ��
		private TextView date;
		private TextView mon;
		private GridView gvImg;
		private TextView zan;
		private TextView howimages;
	}

	// ��ô�������ͼƬ
		private void initimage() {
			ArrayList<String> cfile = readFilePathCache();
			if (cfile != null) {
				listfile = cfile;
			}

			Bundle bundle = ((MyImageActivity) context).getIntent().getExtras();
			if (bundle != null) {
				if (bundle.getStringArrayList("files") != null) {
					ArrayList<String> bfile = bundle.getStringArrayList("files");
					for (String item : bfile) {
						listfile.add(item);
					}

					System.out.println(listfile);
					// ��·��д������
					writeFilePathCache(listfile);

				}

			}
		}

		/**
		 * ��ȡ�������·��
		 */
		private ArrayList<String> readFilePathCache() {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
						"/sdcard/friendscircle/imgges/ShowImage.bin"));
				return (ArrayList<String>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * ɾ���ļ�·��
		 * 
		 * @return
		 */
		private boolean deleteFilePathCache() {
			try {
				File pathFile = new File(
						"/sdcard/friendscircle/imgges/ShowImage.bin");
				if (pathFile.exists()) {
					pathFile.delete();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		/**
		 * ��·��д��������
		 */
		private void writeFilePathCache(ArrayList<String> result) {
			File file = new File("/sdcard/friendscircle/imgges");
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(file.getPath() + "/ShowImage.bin"));
				oos.writeObject(result);
				oos.close();
				System.out.println("д��ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
