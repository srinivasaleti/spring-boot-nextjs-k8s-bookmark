"use client";

import { useEffect, useState } from "react";
import { BookMark, IBookMark } from "./Bookmark";
import { Button } from "./Button";
import { Loader } from "./Loader";

export const BookmarkList = () => {
  const [hasPrev, setHasPrev] = useState(false);
  const [hasNext, setHasNext] = useState(true);
  const [bookmarks, setBookmarks] = useState<IBookMark[]>([]);
  const [page, setPage] = useState(1);
  const pageSize = 5;
  const [loading, setLoading] = useState(true);

  const fetchBookMarks = (page: number) => {
    setLoading(true);
    fetch(
      `${process.env.NEXT_PUBLIC_BOOKMARK_URL}/api/bookmarks?page=${page}&pageSize=${pageSize}`
    )
      .then((response) => {
        return response.json();
      })
      .then((json: any) => {
        setBookmarks(json.data);
        setHasPrev(json.hasPrevious);
        setHasNext(json.hasNext);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  };
  useEffect(() => {
    fetchBookMarks(0);
  }, []);

  const onPrev = () => {
    setPage(page - 1);
    fetchBookMarks(page - 1);
  };
  const onNext = () => {
    setPage(page + 1);
    fetchBookMarks(page + 1);
  };

  if (loading) {
    return <Loader />;
  }

  return (
    <div>
      <div
        style={{
          display: "flex",
          maxWidth: "500px",
          margin: "auto",
          marginTop: "20px",
          flexDirection: "column",
          gap: "12px",
        }}
      >
        {bookmarks.map((bookmark) => (
          <BookMark bookmark={bookmark} key={bookmark.id} />
        ))}

        <div
          style={{
            width: "100%",
            marginTop: "20px",
            display: "flex",
            justifyContent: "space-between",
            gap: "8px",
          }}
        >
          <Button title="Prev" onClick={onPrev} disable={!hasPrev} />
          <Button title="Next" onClick={onNext} disable={!hasNext} />
        </div>
      </div>
    </div>
  );
};
