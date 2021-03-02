# Simple RecyclerView example

RecyclerViews are used to print lists in an efficient way. Only the views that are visible are rendered, making it more efficinet that a classica ListView.

In this very basic example app we are populating a RecyclerView with a list of names. Each row contains the index of the name followed by the same one. To achieve this, we proceed to do the following. 

1. Create a file that represents each row (item_view.xml).
2. Create a RecyclerViewAdapter file to bind the rows data.
  * In the onCreateViewHolder method place the code to inflate a view with the item_view.xml file. This method is called to create the instances of the views that are displayed. This views are saved inside a ViewHolder object, this viewHolder contains important data about the position and visibility of the view inside the recyclerView.
  * The onBind method is called everytime a view (one of the previously created in the onCreateViewHolder method) has to be updated. So this is called every time a view is created or a view is recycled.
  * The getItemCount method helps the adapter to realize when there is no more data to be shown.
  * Create a method where you will pass the data that will be rendered. On this method we will invoke the notifyDataSetChanged method to tell the recyclerView that the data has changed.

3. Add a RecyclerView inside the activity.
4. Setup the recycler view. Two things are required to configure it:
  * First you have to set the layoutManager the recyclerView will use (LinearLayoutManager, GridLayoutManager, StaggeredLayoutManager) In this case we will use the LinearLayoutManager, used to create a list of items vertical or horizontal.
  * Then you will have to create an instance of the adapter you just created to be assigned to the RecyclerView.

5. Invoke the adapters set data method to render the list of items inside the RecyclerView.

## Adding interaction to the RecyclerView items.

So far we have described the process to create a RecyclerView that renders a data set, but any action as clicking on the items will do nothing since there is no way to communicate the rows with the activity, luckily we can do the following to achive this.
1. Create a interface for a new listener that will be passed to each Row of the RecyclerView.
2. In the onBindViewHolder method now we will pass the listener to the rowView, and we will invoke the listener necessary methods when the view gets clicked (Yes, onClickListener will invoke our custom listener)
3. We will pass our listener instance to the Adapter from the activity.
4. In this case, we will let the activity to implement the listener interface, and then we will pass the activity instance as the listener to our adapter.
5. On the activity, we will implement the listener methods and we will execute our desired actions.
