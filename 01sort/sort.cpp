#include <bits/stdc++.h>

using namespace std;
bool sortbyframeno(const pair<int, int> &a, const pair<int, int> &b)
{
    return (a.first < b.first);
}
int main()
{
    vector<pair<int, int>> vect;
    int n;
    cout << "Enter the number of frames" << endl;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x = rand() % 100;
        int data;
        cout << "Enter the data of the frame(" << x << "):" << endl;
        cin >> data;
        vect.push_back({x, data});
    }
    cout << "Before sorting frames:" << endl;
    for (int i = 0; i < vect.size(); i++)
    {
        cout << "Frame" << vect[i].first << ": data is: " << vect[i].second << endl;
    }
    sort(vect.begin(), vect.end(), sortbyframeno);
    cout << "After sorting frames:" << endl;
    for (int i = 0; i < vect.size(); i++)
    {
        cout << "Frame" << vect[i].first << ": data is: " << vect[i].second << endl;
    }
    return 0;
}