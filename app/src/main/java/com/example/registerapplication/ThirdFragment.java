package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ThirdFragment extends Fragment {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ImageView btn_one;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // return inflater.inflate(R.layout.fragment_third, container, false);
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);

        btn_one = (ImageView)rootView.findViewById(R.id.check_your_back_id);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DashboardOneActivity.class);
                startActivity(intent);
            }
        });

        // preparing list data
        prepareListData();
        //  TextView textView = new TextView(ThirdFragment.this.getActivity());

        listAdapter = new ExpandableListAdapter(ThirdFragment.this.getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return rootView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("What's Retinoblastoma?");
        listDataHeader.add("Treatment for Retinoblastoma?");
        listDataHeader.add("Did they get cancer because they were bad? Is this punishment?");
        listDataHeader.add("Will they come back to school for good?");
        listDataHeader.add("Can you die from cancer? Will they die like my grandpa died?");
        listDataHeader.add("Once cancer goes away, can it come back?");
        listDataHeader.add("Can they still go to PE with us when they come back?");
        listDataHeader.add("What do they do when they are in the hospital?");
        listDataHeader.add("Are they still our friend?");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Retinoblastoma is cancer of the retina. The retina is the light-sensitive lining at the back of the eye. During the early stages of a baby's development, retinal eye cells grow very quickly and then stop growing. But in rare cases, 1 or more cells continue to grow and form a cancer called retinoblastoma.");
        top250.add("Retinoblastoma is an eye cancer that begins in the retina — the sensitive lining on the inside of your eye. Retinoblastoma most commonly affects young children, but can rarely occur in adults.");
        top250.add("Because retinoblastoma mostly affects infants and small children, symptoms are rare. Signs you may notice include" +
                "A white color in the center circle of the eye (pupil) when light is shone in the eye, such as when taking a flash photograph\n" +
                "Eyes that appear to be looking in different directions\n" +
                "Eye redness\n" +
                "Eye swelling");
       /* top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");*/

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Most children with eye cancer who begin treatment before the retinoblastoma has spread beyond the eye are cured. A major goal of treatment in children with retinoblastoma is preserving vision. Most children retain their vision and more than 95 percent of children with retinoblastoma can be cured.");
       /* nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");*/

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Sometimes kids with cancer come back to school for good but other times they need to return to the hospital every once in a while to get better. We don't know for sure what their schedule will be like but I know we'll all be happy to see them when they are here.");


        List<String> top251 = new ArrayList<String>();
        top251.add("Some people do die from cancer but many, many kids get better. The doctors are very good at helping kids get better and back to being a regular kid. " );

        List<String> top252 = new ArrayList<String>();
        top252.add("Cancer can come back but for most people it doesn't. If it does happen, they can go back to their doctor for help.");
       /* comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

*/
        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), top251);
        listDataChild.put(listDataHeader.get(4), top252);

    }
}
       /* View v = inflater.inflate(R.layout.saved_tabs, null);
        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
        container.setMinimumHeight(150);

        return v;
    }
    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = { "Q1: What is Retinoblastoma?", "Dog Names", "Cat Names", "Fish Names" };

        private String[][] children = {
                { "\n" +
                        "A. Retinoblastoma(Rb) is a rare from of cancer that rapidly develops from the immature cells of a retina, the light detecting tissue of the eye. It is the most common promary malight intraocular cancer in children , and it is almost exclusive found in young children." },
                { "Ace", "Bandit", "Cha-Cha", "Deuce" },
                { "Fluffy", "Snuggles" },
                { "Goldy", "Bubbles" }
        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(ThirdFragment.this.getActivity());
            textView.setText(getGroup(i).toString());
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(ThirdFragment.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}
*/