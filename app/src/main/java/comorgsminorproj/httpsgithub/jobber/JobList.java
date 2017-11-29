package comorgsminorproj.httpsgithub.jobber;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by MK on 28-11-2017.
 */

public class JobList extends ArrayList<Job> implements Parcelable {

    private static final long serialVersionUID = 663585476779879096L;

    protected JobList(Parcel in) {
        this.clear();
        int size = in.readInt();

        for(int i=0;i<size;i++) {
            Job j = new Job();

            j.jobID = in.readString();
            j.desg = in.readString();
            j.type = in.readString();
            j.salary = in.readString();
            j.qualification = in.readString();
            j.loc = in.createStringArrayList();
            this.add(j);
        }
    }

    public static final Parcelable.Creator<JobList> CREATOR = new Parcelable.Creator<JobList>() {
        @Override
        public JobList createFromParcel(Parcel in) {
            return new JobList(in);
        }

        @Override
        public JobList[] newArray(int size) {
            return null;
        }
    };

    public JobList() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        int size = this.size();
        dest.writeInt(size);
        for(int i=0;i<size;i++) {

            Job j = this.get(i);

            dest.writeString(j.jobID);
            dest.writeString(j.desg);
            dest.writeString(j.type);
            dest.writeString(j.salary);
            dest.writeString(j.qualification);
            dest.writeStringList(j.loc);
        }
    }
}
