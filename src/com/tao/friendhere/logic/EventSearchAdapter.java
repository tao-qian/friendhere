package com.tao.friendhere.logic;

import java.util.List;
import com.parse.ParseObject;
import com.tao.friendhere.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Adapters for searching event(ParseObject).
 * 
 * @author Tao Qian(taoqian_2015@depauw.edu)
 * 
 */
public class EventSearchAdapter extends SearchListAdapter<ParseObject> {

	public EventSearchAdapter(Context mContext, List<ParseObject> listItems) {
		super(mContext, listItems);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder holder;
		ParseObject item = (ParseObject) getItem(position);
		if (row == null) {
			// LayoutInflater inflater = (LayoutInflater)
			// parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = LayoutInflater.from(mContext).inflate(
					R.layout.event_list_item, parent, false);
			holder = new ViewHolder();
			holder.upperText = (TextView) row
					.findViewById(R.id.event_item_upper_text);
			holder.lowerText = (TextView) row
					.findViewById(R.id.event_item_lower_text);

			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}
		holder.upperText.setText(item.getString(ParseContract.Event.NAME));
		holder.lowerText.setText(Utility.truncString(
				item.getString(ParseContract.Event.DESCRIPTION), 15));
		return row;
	}

	/**
	 * View holder to speed up the list item creation process.
	 * 
	 * @author Tao Qian(taoqian_2015@depauw.edu)
	 * 
	 */
	private static class ViewHolder {
		TextView upperText;
		TextView lowerText;
	}

}
