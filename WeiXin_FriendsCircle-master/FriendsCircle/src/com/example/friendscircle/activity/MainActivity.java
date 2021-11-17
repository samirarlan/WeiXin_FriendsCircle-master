package com.example.friendscircle.activity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.friendscircle.R;
import com.example.friendscircle.entity.FriendEntity;
import com.example.friendscircle.util.MyListView;

public class MainActivity extends Activity {
	public static final int NONE = 0;
	public static final int PHOTOHRAPH = 1;// ����
	public static final int PHOTOZOOM = 2; // ����
	public static final int PHOTORESOULT = 3;// ���
	public static final String IMAGE_UNSPECIFIED = "image/*";
	public static final String TEMP_JPG_NAME = "temp.jpg";
	private ListView listView;
	private TextView textView;
	private LinearLayout relativeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		relativeLayout = (LinearLayout) findViewById(R.id.RelativeLayout);
		listView = (ListView) findViewById(R.id.listview);
		ArrayList<String> list = new ArrayList<String>();
		MyListView listView = new MyListView(this, list);
		relativeLayout.addView(listView);
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, list);
		listView.setAdapter(new MyAdapter(setData(), this));
	}

	private List<FriendEntity> setData() {
		List<FriendEntity> friendEntities = new ArrayList<FriendEntity>();
		FriendEntity friendEntity = new FriendEntity();
		friendEntity.setOtherlayout(1);
		friendEntity.setImages(R.drawable.w002);
		friendEntity.setContentimages(R.drawable.s03);
		friendEntity.setName("�Ÿ�");
		friendEntity.setContent("���ǹ�˾������˶��ᣬ��ҿ����ް�");
		friendEntity.setDate("29����ǰ");
		friendEntity.setPraise("���Σ��Ƴɣ���������");
		friendEntity.setCommentary("����!");
		friendEntities.add(friendEntity);

		FriendEntity friendEntity1 = new FriendEntity();
		friendEntity1.setOtherlayout(1);
		friendEntity1.setImages(R.drawable.w001);
		friendEntity1.setContentimages(R.drawable.s03);
		friendEntity1.setName("ʢ����");
		friendEntity1
				.setContent("���ڶ���˹��˵������˹������ֻ�������ǵķ�������װ֮һ�����ԡ����֡�֮�������з��԰�ɳ����Ȩ�Ķ��մ���");
		friendEntity1.setDate("2Сʱǰ QQ�ռ䶯̬");
		friendEntity1.setPraise("��ҹ�»�");
		friendEntity1.setCommentary("����˹����ȡ��������ս��������Ȩ���Ѵ�Ϊ������ɳ�����ԭ�ͼ۸񡭡�");
		friendEntities.add(friendEntity1);
		FriendEntity friendEntity6 = new FriendEntity();
		friendEntity6.setOtherlayout(2);
		friendEntity6.setImages(R.drawable.w004);
		friendEntity6.setContentimages(R.drawable.s03);
		friendEntity6.setName("����");
		friendEntity6.setPraise("�ܵ�");
		friendEntity6.setContent("�Ҿ�����һ��");
		friendEntity6.setDate("һ��ǰ");
		friendEntity6.setCommentary("�±Ҳų������ٳ��Ѻ��С��ٿ����촫������");
		friendEntities.add(friendEntity6);
		FriendEntity friendEntity2 = new FriendEntity();
		friendEntity2.setOtherlayout(2);
		friendEntity2.setPraise("�ܵ�");
		friendEntity2.setImages(R.drawable.w003);
		friendEntity2.setContentimages(R.drawable.s02);
		friendEntity2.setName("������");
		friendEntity2.setContent("PAGEONE���㷢�����");
		friendEntity2.setCommentary("[PAGEONE���������]��������һ�����");
		friendEntity2.setDate("һ��ǰ");
		friendEntities.add(friendEntity2);
		FriendEntity friendEntity3 = new FriendEntity();
		friendEntity3.setOtherlayout(2);
		friendEntity3.setImages(R.drawable.w004);
		friendEntity3.setContentimages(R.drawable.s01);
		friendEntity3.setPraise("�ܵ�");
		friendEntity3.setName("����");
		friendEntity3.setContent("���ע���ˣ�");
		friendEntity3.setDate("һ��ǰ");
		friendEntity3.setCommentary("ǧ��Ҫ������Ȧ�ҵ��ޣ��쿴���������ˣ�");
		friendEntities.add(friendEntity3);
		FriendEntity friendEntity4 = new FriendEntity();
		friendEntity4.setOtherlayout(1);
		friendEntity4.setImages(R.drawable.w005);
		friendEntity4.setContentimages(R.drawable.s03);
		friendEntity4.setName("Jackwaiting");
		friendEntity4
				.setContent("ԭ��Ʒ�Ƹ�banner��������͵���banner��Ʒ��������Ƽ��ɷ�����������19:30��20:30����ʦ���㲻����ɢ���ڴ���ҵ�����~");
		friendEntity4.setDate("2��ǰ");
		friendEntity4.setPraise("��į");
		friendEntity4.setCommentary("����!");
		friendEntities.add(friendEntity4);
		FriendEntity friendEntity5 = new FriendEntity();
		friendEntity5.setOtherlayout(1);
		friendEntity5.setImages(R.drawable.w006);
		friendEntity5.setContentimages(R.drawable.s03);
		friendEntity5.setName("����ʤ");
		friendEntity5
				.setContent("��������Ҫ�����Ǳ��죬Ȼ����ǰ����ȥ����˵������˵����ʱ��ȥ����ǰû�����¡����ͣ�������������");
		friendEntity5.setDate("2��ǰ");
		friendEntity5.setPraise("С���ӣ�·�˼ף��ڣ�Ф�ξ����ɸ�");
		friendEntity5.setCommentary("С����  : ʤ�����䣡\n ��  : ����!����!");
		friendEntities.add(friendEntity5);
		return friendEntities;
	}

	private Bitmap photo;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		try {

			if (resultCode == NONE)
				return;

			// ����
			if (requestCode == PHOTOHRAPH) {
				// �����ļ�����·��������ڸ�Ŀ¼��
				File picture = new File(Environment
						.getExternalStorageDirectory().getAbsolutePath(),
						TEMP_JPG_NAME);
				startPhotoZoom(Uri.fromFile(picture));
			}

			if (data == null)
				return;

			// ��ȡ�������ͼƬ
			if (requestCode == PHOTOZOOM) {
				/*
				 * Uri image = data.getData();
				 * Toast.makeText(MymessageActivity.this,image+"",
				 * Toast.LENGTH_LONG).show();
				 */

				if (data != null) {
					startPhotoZoom(data.getData());
				} else {
					System.out.println("================");
				}

			}

			// ������
			if (requestCode == PHOTORESOULT) {
				Bundle extras = data.getExtras();
				if (extras != null) {
					// Toast.makeText(MainActivity.this,Environment.getExternalStorageDirectory().getAbsolutePath()+"/SmartTableLamp/",
					// Toast.LENGTH_LONG).show();
					photo = extras.getParcelable("data");

					listView.setAdapter(new MyAdapter(setData(), this, photo, 4));
					// ByteArrayOutputStream stream = new
					// ByteArrayOutputStream();
					// comp(photo);
					// photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
					// riv_logo.setImageBitmap(photo);
					// ����bitmapд�뻺�棬׼���ϴ�
					// SelectPicUtil.bitmapToBase64(photo,
					// MymessageActivity.this);
					/*
					 * logoName =
					 * FileUtils.getFilename(MainAppUtil.getCustom().getSusername
					 * ()); FileUtils.writeFile(Constants.LOGO_CACHE_PATH,
					 * logoName, photo);
					 */
				}
			}

			super.onActivityResult(requestCode, resultCode, data);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private Bitmap compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// ����ѹ������������100��ʾ��ѹ������ѹ��������ݴ�ŵ�baos��
		int options = 100;
		while (baos.toByteArray().length / 1024 > 100) { // ѭ���ж����ѹ����ͼƬ�Ƿ����100kb,���ڼ���ѹ��
			baos.reset();// ����baos�����baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// ����ѹ��options%����ѹ��������ݴ�ŵ�baos��
			options -= 10;// ÿ�ζ�����10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// ��ѹ���������baos��ŵ�ByteArrayInputStream��
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// ��ByteArrayInputStream��������ͼƬ
		return bitmap;
	}

	private Bitmap comp(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		if (baos.toByteArray().length / 1024 > 1024) {
			// �ж����ͼƬ����1M,����ѹ������������ͼƬ��BitmapFactory.decodeStream��ʱ���
			baos.reset();// ����baos�����baos
			image.compress(Bitmap.CompressFormat.JPEG, 50, baos);
			// ����ѹ��50%����ѹ��������ݴ�ŵ�baos��
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// ��ʼ����ͼƬ����ʱ��options.inJustDecodeBounds ���true��
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		// ���������ֻ��Ƚ϶���800*500�ֱ��ʣ����ԸߺͿ���������Ϊ
		float hh = 800f;// �������ø߶�Ϊ800f
		float ww = 500f;// �������ÿ��Ϊ500f
		// ���űȡ������ǹ̶��������ţ�ֻ�ø߻��߿�����һ�����ݽ��м��㼴��
		int be = 1;// be=1��ʾ������
		if (w > h && w > ww) {// �����ȴ�Ļ����ݿ�ȹ̶���С����
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// ����߶ȸߵĻ����ݿ�ȹ̶���С����
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// �������ű���
		// ���¶���ͼƬ��ע���ʱ�Ѿ���options.inJustDecodeBounds ���false��
		isBm = new ByteArrayInputStream(baos.toByteArray());
		bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		return compressImage(bitmap);// ѹ���ñ�����С���ٽ�������ѹ��
	}

	private void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
		intent.putExtra("crop", "true");
		// aspectX aspectY �ǿ�ߵı���
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY �ǲü�ͼƬ���
		intent.putExtra("outputX", 300);
		intent.putExtra("outputY", 300);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, PHOTORESOULT);
	}

}
